package com.github.odaridavid.designpatterns.builder

import android.os.Bundle
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.databinding.ActivityBuilderBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class BuilderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBuilderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.builderLayout.designPatternDescription.text = getString(R.string.desc_builder)
        binding.builderLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.BUILDER)
    }
}
