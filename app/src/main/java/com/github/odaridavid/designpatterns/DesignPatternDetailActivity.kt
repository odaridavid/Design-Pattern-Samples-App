package com.github.odaridavid.designpatterns

import android.os.Bundle
import com.github.odaridavid.designpatterns.databinding.ActivityDesignPatternDetailBinding

class DesignPatternDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDesignPatternDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val designPattern =
            intent.getParcelableExtra<DesignPattern>(NavigationController.KEY_DESIGN_PATTERN)
                ?: return

        supportActionBar?.setTitle(designPattern.name)
        binding.designPatternDescriptionTextView.text = getString(designPattern.description)
        binding.designPatternMarkdownView.loadWithKotlinCss(designPattern.codeSample)
    }
}
