package com.github.odaridavid.designpatterns.templatemethod

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityTemplateBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class TemplateMethodActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTemplateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.templateLayout.designPatternDescription.text = getString(R.string.desc_template)
        binding.templateLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.TEMPLATE_METHOD)
    }
}
