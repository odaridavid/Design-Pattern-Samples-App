package com.github.odaridavid.designpatterns.abstractfactory

import android.os.Bundle
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.databinding.ActivityAbstractFactoryBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class AbstractFactoryActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAbstractFactoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.abstractFactoryLayout.designPatternDescription.text =
            getString(R.string.desc_abstract_factory)
        binding.abstractFactoryLayout.designPatternMarkdownView.loadWithKotlinCss(
            CodeSample.ABSTRACT_FACTORY
        )
    }
}
