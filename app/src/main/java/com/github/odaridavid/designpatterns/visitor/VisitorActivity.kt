package com.github.odaridavid.designpatterns.visitor

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityVisitorBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class VisitorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityVisitorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.visitorLayout.designPatternDescription.text = getString(R.string.desc_visitor)
        binding.visitorLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.VISITOR)
    }
}
