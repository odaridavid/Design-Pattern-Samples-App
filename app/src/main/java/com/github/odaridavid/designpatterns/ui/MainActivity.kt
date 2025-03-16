package com.github.odaridavid.designpatterns.ui

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.ColorRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.github.odaridavid.designpatterns.InAppReviewManager
import com.github.odaridavid.designpatterns.InAppUpdateManager
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.BaseActivity
import com.github.odaridavid.designpatterns.databinding.ActivityMainBinding
import com.github.odaridavid.designpatterns.helpers.*
import com.github.odaridavid.designpatterns.models.generateDesignPatterns
import com.github.odaridavid.designpatterns.pref.IPreferenceManager
import com.google.android.play.core.install.model.ActivityResult
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

internal class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val prefManager: IPreferenceManager by lazy {
        InjectorUtils.providePreferenceManager(baseContext)
    }

    private val activityResult =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            when (result.resultCode) {
                Activity.RESULT_OK -> showToast(getString(R.string.app_update_success))
                Activity.RESULT_CANCELED -> showToast(getString(R.string.app_update_cancelled))
                ActivityResult.RESULT_IN_APP_UPDATE_FAILED -> showToast(getString(R.string.app_update_failed))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDesignPatternsAdapter()
        InAppUpdateManager.checkForUpdate(applicationContext, activityResult)

        setupRatingPrompt()
    }

    private fun setupRatingPrompt() {
        with(prefManager) {
            if (!hasRated) {
                ratingPromptCount++
                if (ratingPromptCount % 5 == 0) showRatingAlertDialog(this)
            }
        }
    }

    private fun showRatingAlertDialog(preferenceManager: IPreferenceManager) {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.title_rating_dialog))
            .setMessage(getString(R.string.info_rating_message))
            .setNegativeButton(getString(R.string.label_dialog_negative_button), null)
            .setPositiveButton(getString(R.string.label_dialog_positive_button)) { _, _ ->
                preferenceManager.hasRated = true
                InAppReviewManager().requestAndLaunchReview(this)
            }
            .setCancelable(true)
            .create()
            .apply {
                show()
                setButtonColors()
            }
    }

    private fun AlertDialog.setButtonColors() {
        fun loadColor(@ColorRes colorRes: Int) = ContextCompat.getColor(this@MainActivity, colorRes)
        getButton(AlertDialog.BUTTON_POSITIVE)?.setTextColor(loadColor(R.color.colorText))
        getButton(AlertDialog.BUTTON_NEGATIVE)?.setTextColor(loadColor(R.color.colorText))
    }

    private fun setupDesignPatternsAdapter() {
        val designPatternsAdapter = DesignPatternsAdapter { designPattern ->
            navigateTo<DesignPatternDetailActivity> {
                it.putExtra(NavigationUtils.KEY_DESIGN_PATTERN, designPattern)
            }
        }
        binding.designPatternsRecyclerView.apply {
            addItemDecoration(GridSpaceItemDecoration(ViewUtils.convertDpToPixel(context, 8)))
            adapter = ScaleInAnimationAdapter(designPatternsAdapter.apply {
                submitList(generateDesignPatterns())
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                navigateTo<AboutActivity>(); true
            }

            R.id.action_settings -> {
                navigateTo<SettingsActivity>(); true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}

