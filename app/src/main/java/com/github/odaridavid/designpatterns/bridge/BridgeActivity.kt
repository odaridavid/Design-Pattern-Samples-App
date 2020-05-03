package com.github.odaridavid.designpatterns.bridge

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityBridgeBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class BridgeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBridgeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bridgeLayout.designPatternDescription.text = getString(R.string.desc_bridge)
        binding.bridgeLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.BRIDGE)
    }
}
