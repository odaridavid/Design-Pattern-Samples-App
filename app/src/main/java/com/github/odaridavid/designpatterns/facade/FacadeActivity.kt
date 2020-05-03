package com.github.odaridavid.designpatterns.facade

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityFacadeBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class FacadeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFacadeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.facadeLayout.designPatternDescription.text = getString(R.string.desc_facade)
        binding.facadeLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.FACADE)
    }
}
