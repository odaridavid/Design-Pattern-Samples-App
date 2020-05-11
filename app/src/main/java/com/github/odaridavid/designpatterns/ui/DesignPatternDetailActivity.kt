package com.github.odaridavid.designpatterns.ui

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import androidx.annotation.RequiresApi
import com.github.odaridavid.designpatterns.base.BaseActivity
import com.github.odaridavid.designpatterns.base.ISystemThemeChangeListener
import com.github.odaridavid.designpatterns.databinding.ActivityDesignPatternDetailBinding
import com.github.odaridavid.designpatterns.helpers.DARK_KOTLIN_CSS_PATH
import com.github.odaridavid.designpatterns.helpers.LIGHT_KOTLIN_CSS_PATH
import com.github.odaridavid.designpatterns.helpers.NavigationUtils
import com.github.odaridavid.designpatterns.helpers.loadWithKotlinCss
import com.github.odaridavid.designpatterns.models.DesignPattern

class DesignPatternDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDesignPatternDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val designPattern =
            intent.getParcelableExtra<DesignPattern>(NavigationUtils.KEY_DESIGN_PATTERN)
                ?: return

        supportActionBar?.setTitle(designPattern.name)
        binding.designPatternDescriptionTextView.text = getString(designPattern.description)
        binding.designPatternMarkdownView.loadWithKotlinCss(
            baseContext,
            designPattern.codeSample,
            this as ISystemThemeChangeListener<String>
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onPowerSaverModeChange(powerManager: PowerManager): String {
        super.onPowerSaverModeChange(powerManager)
        return if (powerManager.isPowerSaveMode) DARK_KOTLIN_CSS_PATH else LIGHT_KOTLIN_CSS_PATH
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onUiModeConfigChange(): String {
        super.onUiModeConfigChange()
        return when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> LIGHT_KOTLIN_CSS_PATH
            Configuration.UI_MODE_NIGHT_YES -> DARK_KOTLIN_CSS_PATH
            else -> LIGHT_KOTLIN_CSS_PATH
        }
    }
}
