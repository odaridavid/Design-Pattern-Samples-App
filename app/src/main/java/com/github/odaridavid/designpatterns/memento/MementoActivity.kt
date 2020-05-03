package com.github.odaridavid.designpatterns.memento

import android.os.Bundle
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.databinding.ActivityMementoBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class MementoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMementoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.mementoLayout.designPatternDescription.text = getString(R.string.desc_memento)
        binding.mementoLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.MEMENTO)
    }
}
