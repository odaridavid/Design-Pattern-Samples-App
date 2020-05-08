package com.github.odaridavid.designpatterns.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.odaridavid.designpatterns.InAppUpdateManager
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.BaseActivity
import com.github.odaridavid.designpatterns.databinding.ActivityMainBinding
import com.github.odaridavid.designpatterns.helpers.NavigationUtils
import com.github.odaridavid.designpatterns.helpers.navigateTo
import com.github.odaridavid.designpatterns.helpers.showToast
import com.github.odaridavid.designpatterns.models.generateDesignPatterns
import com.google.android.play.core.install.model.ActivityResult
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDesignPatternsAdapter()

        InAppUpdateManager(baseContext, this).checkForUpdate()
    }

    private fun setupDesignPatternsAdapter() {
        val designPatternsAdapter =
            DesignPatternsAdapter { designPattern ->
                navigateTo<DesignPatternDetailActivity>() { intent ->
                    intent.putExtra(NavigationUtils.KEY_DESIGN_PATTERN, designPattern)
                }
            }
        val designPatterns =
            generateDesignPatterns()
        binding.designPatternsRecyclerView.addItemDecoration(
            GridSpaceItemDecoration(16)
        )
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

}
