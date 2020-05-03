package com.github.odaridavid.designpatterns.strategy

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityStrategyBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class StrategyActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStrategyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.strategyLayout.designPatternDescription.text = getString(R.string.desc_strategy)
        binding.strategyLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.STRATEGY)
    }
}
