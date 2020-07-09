package com.github.odaridavid.designpatterns.ui

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.ColorRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDesignPatternsAdapter()

        InAppUpdateManager.checkForUpdate(this)

        with(prefManager) {
            if (hasRated) return@with
            ratingPromptCount++
            val isFifthTime = ratingPromptCount % 5 == 0
            if (isFifthTime) {
                showRatingAlertDialog(this)
            }
        }
    }

    private fun showRatingAlertDialog(preferenceManager: IPreferenceManager) {
        val dialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.title_rating_dialog))
            .setMessage(getString(R.string.info_rating_message))
            .setNegativeButton(getString(R.string.label_dialog_negative_button), null)
            .setPositiveButton(getString(R.string.label_dialog_positive_button)) { _, _ ->
                preferenceManager.hasRated = true
                navigateToGooglePlayStore()
            }
            .setCancelable(true)
            .create()
        dialog.show()
        dialog.apply { setButtonColors() }
    }

    private fun AlertDialog.setButtonColors() {
        fun loadColor(@ColorRes colorRes: Int): Int {
            return ContextCompat.getColor(this@MainActivity, colorRes)
        }
        getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(loadColor(R.color.colorText))
        getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(loadColor(R.color.colorText))
    }

    private fun navigateToGooglePlayStore() {
        var gplayAvailable = false
        val appUri = "$PLAYSTORE_APP_URI$packageName".toUri()
        val ratingIntent = Intent(Intent.ACTION_VIEW, appUri)
        val gplayAppInfo = packageManager.queryIntentActivities(ratingIntent, 0)
            .filter { it.activityInfo.applicationInfo.packageName == "com.android.vending" }
        if (gplayAppInfo.isNotEmpty()) {
            buildPlaystoreIntent(gplayAppInfo, ratingIntent)
            gplayAvailable = true
            startActivity(ratingIntent)
        }
        if (!gplayAvailable) {
            val webIntent = Intent(Intent.ACTION_VIEW, "$PLAYSTORE_WEB_URI$packageName".toUri())
            startActivity(webIntent)
        }
    }

    private fun buildPlaystoreIntent(gplayAppInfo: List<ResolveInfo>, rateIntent: Intent) {
        val gplayActivityInfo = gplayAppInfo.first().activityInfo
        val gplayComponent = ComponentName(
            gplayActivityInfo.applicationInfo.packageName,
            gplayActivityInfo.name
        )
        with(rateIntent) {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            setComponent(gplayComponent)
        }
    }

    private fun setupDesignPatternsAdapter() {
        val designPatternsAdapter = DesignPatternsAdapter { designPattern ->
            navigateTo<DesignPatternDetailActivity>() { intent ->
                intent.putExtra(NavigationUtils.KEY_DESIGN_PATTERN, designPattern)
            }
        }
        val designPatterns = generateDesignPatterns()
        val spacing = ViewUtils.convertDpToPixel(this, 8)
        binding.designPatternsRecyclerView.addItemDecoration(GridSpaceItemDecoration(spacing))
        binding.designPatternsRecyclerView.adapter =
            ScaleInAnimationAdapter(designPatternsAdapter.apply { submitList(designPatterns) })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (InAppUpdateManager.RQ_REQUEST_UPDATE == requestCode) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    showToast(getString(R.string.app_update_success))
                }
                Activity.RESULT_CANCELED -> {
                    showToast(getString(R.string.app_update_cancelled))
                }
                ActivityResult.RESULT_IN_APP_UPDATE_FAILED -> {
                    showToast(getString(R.string.app_update_failed))
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                navigateTo<AboutActivity>()
                true
            }
            R.id.action_settings -> {
                navigateTo<SettingsActivity>()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        private const val PLAYSTORE_WEB_URI = "https://play.google.com/store/apps/details?id="
        private const val PLAYSTORE_APP_URI = "market://details?id="
    }

}
