package com.github.odaridavid.designpatterns.mediator

import android.os.Bundle
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.databinding.ActivityMediatorBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class MediatorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMediatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.mediatorLayout.designPatternDescription.text = getString(R.string.desc_mediator)
        binding.mediatorLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.MEDIATOR)
    }
}
