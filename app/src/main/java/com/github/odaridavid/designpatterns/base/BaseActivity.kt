package com.github.odaridavid.designpatterns.base

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.PowerManager
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.helpers.SdkUtils.versionFrom
import com.github.odaridavid.designpatterns.helpers.SdkUtils.versionUntil
import com.github.odaridavid.designpatterns.helpers.ThemeUtils

abstract class BaseActivity : AppCompatActivity() {

    private val powerManager: PowerManager by lazy {
        getSystemService(Context.POWER_SERVICE) as PowerManager
    }

    override fun onResume() {
        matchSystemBarsWithBackground()
        super.onResume()
    }

    private fun matchSystemBarsWithBackground() {
        val sp = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val theme = sp.getString(getString(R.string.key_theme_preference), ThemeUtils.THEME_LIGHT)
        if (versionFrom(Build.VERSION_CODES.M))
            handleSystemBars(theme)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun handleSystemBars(theme: String?) {
        when (theme) {
            ThemeUtils.THEME_LIGHT -> setLightSystemBars()
            ThemeUtils.THEME_DARK -> setDarkSystemBars()
            ThemeUtils.THEME_SYSTEM -> {
                if (versionUntil(Build.VERSION_CODES.P)) {
                    onPowerSaverModeChange()
                } else {
                    onUiModeConfigChange()
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun onPowerSaverModeChange() {
        if (powerManager.isPowerSaveMode)
            setDarkSystemBars()
        else
            setLightSystemBars()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun onUiModeConfigChange() {
        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {
                setLightSystemBars()
            }
            Configuration.UI_MODE_NIGHT_YES -> {
                setDarkSystemBars()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setLightSystemBars() {
        if (versionFrom(Build.VERSION_CODES.O)) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        window.statusBarColor = getColor(android.R.color.background_light)
        window.navigationBarColor = getColor(android.R.color.background_light)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setDarkSystemBars() {
        window.statusBarColor = getColor(android.R.color.background_dark)
        window.navigationBarColor = getColor(android.R.color.background_dark)
    }
}
