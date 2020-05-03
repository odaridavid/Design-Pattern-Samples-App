package com.github.odaridavid.designpatterns.observer

import android.os.Bundle
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.databinding.ActivityObserverBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class ObserverActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityObserverBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.observerLayout.designPatternDescription.text = getString(R.string.desc_observer)
        binding.observerLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.OBSERVER)
    }
}
