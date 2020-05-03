package com.github.odaridavid.designpatterns.state

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityStateBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class StateActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.stateLayout.designPatternDescription.text = getString(R.string.desc_state)
        binding.stateLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.STATE)
    }
}
