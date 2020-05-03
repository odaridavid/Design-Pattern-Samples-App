package com.github.odaridavid.designpatterns.singleton

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivitySingletonBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class SingletonActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySingletonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.singletonLayout.designPatternDescription.text = getString(R.string.desc_singleton)
        binding.singletonLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.SINGLETON)
    }
}
