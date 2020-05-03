package com.github.odaridavid.designpatterns.prototype

import android.os.Bundle
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.databinding.ActivityPrototypeBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class PrototypeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPrototypeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.prototypeLayout.designPatternDescription.text = getString(R.string.desc_prototype)
        binding.prototypeLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.PROTOTYPE)
    }
}
