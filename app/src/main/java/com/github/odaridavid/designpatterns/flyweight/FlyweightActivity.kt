package com.github.odaridavid.designpatterns.flyweight

import android.os.Bundle
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.databinding.ActivityFlyweightBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class FlyweightActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFlyweightBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.flyweightLayout.designPatternDescription.text = getString(R.string.desc_flyweight)
        binding.flyweightLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.FLYWEIGHT)
    }
}
