package com.github.odaridavid.designpatterns.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.net.toUri
import com.github.odaridavid.designpatterns.BuildConfig
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.BaseActivity
import com.github.odaridavid.designpatterns.databinding.ActivityAboutBinding
import com.github.odaridavid.designpatterns.helpers.checkUrlScheme
import com.mikepenz.aboutlibraries.Libs
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

internal class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appVersionTextView.text =
            getString(
                R.string.template_app_version,
                BuildConfig.VERSION_NAME
            )
        binding.privacyPolicyTextView.setOnClickListener { openBrowser(APP_PRIVACY_POLICY_URL) }

        val librariesAdapter = initLibrariesAdapter()

        binding.licensesRecyclerView.adapter = ScaleInAnimationAdapter(librariesAdapter)
    }

    private fun initLibrariesAdapter(): LibrariesAdapter {
        val libraries = Libs(this).libraries
        return LibrariesAdapter { url ->
            val repoUrl = url.checkUrlScheme()
            openBrowser(repoUrl)
        }.apply { submitList(libraries) }
    }

    private fun openBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, url.toUri())
        startActivity(browserIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_open_source_code -> {
                openBrowser(APP_REPO_URL)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val APP_REPO_URL = "https://github.com/odaridavid/Design-Pattern-Samples-App"
        const val APP_PRIVACY_POLICY_URL = "https://design-patterns.flycricket.io/privacy.html"
    }

}
