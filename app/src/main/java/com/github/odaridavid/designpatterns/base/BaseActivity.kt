package com.github.odaridavid.designpatterns.base

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.os.PowerManager
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.helpers.InjectorUtils
import com.github.odaridavid.designpatterns.helpers.SdkUtils.versionFrom
import com.github.odaridavid.designpatterns.helpers.SdkUtils.versionUntil
import com.github.odaridavid.designpatterns.helpers.ThemeUtils

internal abstract class BaseActivity : AppCompatActivity(), ISystemThemeChangeListener<Any> {

    private val powerManager: PowerManager by lazy {
        getSystemService(Context.POWER_SERVICE) as PowerManager
    }

    protected val sharedPref: SharedPreferences by lazy {
        InjectorUtils.provideSharedPreferences(this)
    }

    override fun onResume() {
        if (versionFrom(Build.VERSION_CODES.M))
            matchSystemBarsWithBackground()
        else
            initSystemBarsWithDefaultColors()
        super.onResume()
    }

    private fun initSystemBarsWithDefaultColors() {
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.background_dark)
        window.navigationBarColor = ContextCompat.getColor(this, android.R.color.background_dark)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun matchSystemBarsWithBackground() {
        val sp = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val theme = sp.getString(getString(R.string.key_theme_preference), ThemeUtils.THEME_LIGHT)
        handleSystemBars(theme)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun handleSystemBars(theme: String?) {
        when (theme) {
            ThemeUtils.THEME_LIGHT -> setLightSystemBars()
            ThemeUtils.THEME_DARK -> setDarkSystemBars()
            ThemeUtils.THEME_SYSTEM -> {
                if (versionUntil(Build.VERSION_CODES.P))
                    onPowerSaverModeChange(powerManager)
                else
                    onUiModeConfigChange()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onPowerSaverModeChange(powerManager: PowerManager): Any {
        return if (powerManager.isPowerSaveMode) setDarkSystemBars() else setLightSystemBars()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onUiModeConfigChange(): Any {
        return when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> setLightSystemBars()
            Configuration.UI_MODE_NIGHT_YES -> setDarkSystemBars()
            else -> throw IllegalStateException()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setLightSystemBars() {
        window.decorView.systemUiVisibility = setUiVisibilityFlags()
        window.statusBarColor = getColor(android.R.color.background_light)
        window.navigationBarColor = getColor(android.R.color.background_light)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setUiVisibilityFlags(): Int =
        if (versionFrom(Build.VERSION_CODES.O))
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        else
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR


    @RequiresApi(Build.VERSION_CODES.M)
    private fun setDarkSystemBars() {
        window.statusBarColor = getColor(android.R.color.background_dark)
        window.navigationBarColor = getColor(android.R.color.background_dark)
    }
}
