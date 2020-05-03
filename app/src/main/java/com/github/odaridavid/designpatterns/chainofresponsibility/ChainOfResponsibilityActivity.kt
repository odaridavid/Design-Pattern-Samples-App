package com.github.odaridavid.designpatterns.chainofresponsibility

import android.os.Bundle
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.databinding.ActivityChainOfResponsibilityBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class ChainOfResponsibilityActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChainOfResponsibilityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.corLayout.designPatternDescription.text =
            getString(R.string.desc_chain_of_responsibility)
        binding.corLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.CHAIN_OF_RESPONSIBILITY)
    }
}
