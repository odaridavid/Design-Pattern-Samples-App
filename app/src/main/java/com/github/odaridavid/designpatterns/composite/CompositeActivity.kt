package com.github.odaridavid.designpatterns.composite

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityCompositeBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class CompositeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCompositeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.compositeLayout.designPatternDescription.text = getString(R.string.desc_composite)
        binding.compositeLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.COMPOSITE)
    }
}
