package com.github.odaridavid.designpatterns.decorator

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityDecoratorBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class DecoratorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDecoratorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.decoratorLayout.designPatternDescription.text = getString(R.string.desc_decorator)
        binding.decoratorLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.DECORATOR)
    }
}
