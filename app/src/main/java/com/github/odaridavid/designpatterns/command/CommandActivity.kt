package com.github.odaridavid.designpatterns.command

import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.BaseActivity
import com.github.odaridavid.designpatterns.CodeSample
import com.github.odaridavid.designpatterns.databinding.ActivityCommandBinding
import com.github.odaridavid.designpatterns.loadWithKotlinCss

class CommandActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCommandBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.commandLayout.designPatternDescription.text = getString(R.string.desc_command)
        binding.commandLayout.designPatternMarkdownView.loadWithKotlinCss(CodeSample.COMMAND)
    }
}
