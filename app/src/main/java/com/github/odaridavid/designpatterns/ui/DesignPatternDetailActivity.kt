package com.github.odaridavid.designpatterns.ui

import android.os.Bundle
import com.github.odaridavid.designpatterns.base.BaseActivity
import com.github.odaridavid.designpatterns.databinding.ActivityDesignPatternDetailBinding
import com.github.odaridavid.designpatterns.helpers.NavigationUtils
import com.github.odaridavid.designpatterns.helpers.loadWithKotlinCss
import com.github.odaridavid.designpatterns.models.DesignPattern

class DesignPatternDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDesignPatternDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val designPattern =
            intent.getParcelableExtra<DesignPattern>(NavigationUtils.KEY_DESIGN_PATTERN)
                ?: return

        supportActionBar?.setTitle(designPattern.name)
        binding.designPatternDescriptionTextView.text = getString(designPattern.description)
        binding.designPatternMarkdownView.loadWithKotlinCss(designPattern.codeSample)
    }
}
