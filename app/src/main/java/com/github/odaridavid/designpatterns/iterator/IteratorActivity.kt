package com.github.odaridavid.designpatterns.iterator

import android.os.Bundle
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.databinding.ActivityIteratorBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class IteratorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIteratorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.iteratorLayout.designPatternDescription.text = getString(R.string.desc_iterator)
        binding.iteratorLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.ITERATOR)
    }
}
