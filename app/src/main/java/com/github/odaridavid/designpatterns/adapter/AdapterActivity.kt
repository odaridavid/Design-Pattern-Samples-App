package com.github.odaridavid.designpatterns.adapter

import android.os.Bundle
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.databinding.ActivityAdapterBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class AdapterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAdapterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.adapterLayout.designPatternDescription.text = getString(R.string.desc_adapter)
        binding.adapterLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.ADAPTER)
    }
}
