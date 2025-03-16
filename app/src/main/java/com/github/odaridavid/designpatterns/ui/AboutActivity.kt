package com.github.odaridavid.designpatterns.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.net.toUri
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.BaseActivity
import com.github.odaridavid.designpatterns.databinding.ActivityAboutBinding
import com.github.odaridavid.designpatterns.helpers.checkUrlScheme
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.util.withContext
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

internal class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appVersionTextView.text =
            getString(
                R.string.template_app_version,
                "1.3.1"
            )
        binding.privacyPolicyTextView.setOnClickListener { openBrowser(getString(R.string.https_design_patterns_flycricket_io_privacy_html)) }

        val librariesAdapter = initLibrariesAdapter()

        binding.licensesRecyclerView.adapter = ScaleInAnimationAdapter(librariesAdapter)
    }

    private fun initLibrariesAdapter(): LibrariesAdapter {
        val libraries = Libs.Builder().withContext(this).build().libraries

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
                openBrowser(getString(R.string.https_github_com_odaridavid_design_pattern_samples_app))
                true
            }

            R.id.action_share_app -> {
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,
                        getString(
                            R.string.checkout_kotlin_design_patterns_samples_https_play_google_com_store_apps_details_id,
                            packageName
                        )
                    )
                    type = "text/plain"
                }
                startActivity(sendIntent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
