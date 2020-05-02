package com.github.odaridavid.designpatterns

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.odaridavid.designpatterns.databinding.ActivityMainBinding
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class MainActivity : BaseActivity() {

    //TODO show code examples in UI
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupDesignPatternsAdapter()
    }

    private fun setupDesignPatternsAdapter() {
        val designPatternsAdapter = DesignPatternsAdapter { id ->
            NavigationController(this).navigateTo(id)
        }
        val designPatterns = generateDesignPatterns()
        binding.designPatternsRecyclerView.addItemDecoration(GridSpaceItemDecoration(16))
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
