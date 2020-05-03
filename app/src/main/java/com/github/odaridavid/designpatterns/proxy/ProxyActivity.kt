package com.github.odaridavid.designpatterns.proxy

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityProxyBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class ProxyActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProxyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.proxyLayout.designPatternDescription.text = getString(R.string.desc_proxy)
        binding.proxyLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.PROXY)
    }
}
