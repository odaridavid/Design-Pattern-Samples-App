package com.github.odaridavid.designpatterns.factory

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityFactoryBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class FactoryActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFactoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.factoryLayout.designPatternDescription.text = getString(R.string.desc_factory)
        binding.factoryLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.FACTORY)
    }
}
