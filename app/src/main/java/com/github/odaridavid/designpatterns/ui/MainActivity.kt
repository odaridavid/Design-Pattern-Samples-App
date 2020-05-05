package com.github.odaridavid.designpatterns.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.BaseActivity
import com.github.odaridavid.designpatterns.databinding.ActivityMainBinding
import com.github.odaridavid.designpatterns.helpers.NavigationUtils
import com.github.odaridavid.designpatterns.helpers.navigateTo
import com.github.odaridavid.designpatterns.models.generateDesignPatterns
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupDesignPatternsAdapter()
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
            GridSpaceItemDecoration(
                16
            )
        )
        binding.designPatternsRecyclerView.adapter =
            ScaleInAnimationAdapter(designPatternsAdapter.apply { submitList(designPatterns) })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                navigateTo<AboutActivity>()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
