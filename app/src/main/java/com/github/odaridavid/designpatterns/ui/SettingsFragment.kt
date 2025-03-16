package com.github.odaridavid.designpatterns.ui

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.ISystemThemeChangeListener
import com.github.odaridavid.designpatterns.helpers.SdkUtils
import com.github.odaridavid.designpatterns.helpers.SdkUtils.versionUntil
import com.github.odaridavid.designpatterns.helpers.ThemeUtils
import com.github.odaridavid.designpatterns.helpers.ThemeUtils.THEME_DARK
import com.github.odaridavid.designpatterns.helpers.ThemeUtils.THEME_LIGHT
import com.github.odaridavid.designpatterns.helpers.ThemeUtils.THEME_SYSTEM

internal class SettingsFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener, ISystemThemeChangeListener<Int> {

    private var themePreference: ListPreference? = null
    private val themePreferenceKey: String by lazy {
        getString(R.string.key_theme_preference)
    }
    private val powerManager: PowerManager by lazy {
        requireContext().getSystemService(Context.POWER_SERVICE) as PowerManager
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        themePreference = findPreference(themePreferenceKey)

        configPreference(themePreference)

        preferenceManager.sharedPreferences?.registerOnSharedPreferenceChangeListener(this)
    }

    private fun configPreference(themePreference: ListPreference?) {
        val themeArrayOptionsAboveQ = resources.getStringArray(R.array.theme_options_above_q)
        val themeArrayOptionsBelowQ = resources.getStringArray(R.array.theme_options_below_q)

        themePreference?.entries =
            if (SdkUtils.versionFrom(Build.VERSION_CODES.Q))
                themeArrayOptionsAboveQ
            else
                themeArrayOptionsBelowQ

        themePreference?.summaryProvider =
            Preference.SummaryProvider<ListPreference> { preference ->
                getString(getPreferenceSummary(preference))
            }
    }

    @StringRes
    private fun getPreferenceSummary(preference: ListPreference): Int {
        return when (preference.value) {
            THEME_LIGHT -> R.string.pref_summary_theme_light
            THEME_DARK -> R.string.pref_summary_theme_dark
            THEME_SYSTEM -> {
                if (SdkUtils.versionFrom(Build.VERSION_CODES.Q))
                    R.string.pref_summary_theme_system_above_q
                else
                    R.string.pref_summary_theme_system_below_q
            }
            else -> R.string.pref_summary_theme_light
        }
    }

    private fun setupThemePreferenceIcons(themePreference: ListPreference?) {
        val sp = preferenceManager.sharedPreferences
        val themeValue = sp?.getString(themePreferenceKey, DEFAULT_THEME_VALUE)
        themePreference?.icon = getDrawable(requireContext(), getThemeIcon(themeValue))
    }

    @DrawableRes
    private fun getThemeIcon(themeValue: String?): Int {
        return when (themeValue) {
            THEME_LIGHT -> R.drawable.ic_day_black_24dp
            THEME_DARK -> R.drawable.ic_night_black_24dp
            THEME_SYSTEM -> {
                if (versionUntil(Build.VERSION_CODES.P)) {
                    onPowerSaverModeChange(powerManager)
                } else {
                    onUiModeConfigChange()
                }
            }
            else -> R.drawable.ic_day_black_24dp
        }
    }

    override fun onResume() {
        super.onResume()
        setupThemePreferenceIcons(themePreference)
    }

    override fun onDestroy() {
        super.onDestroy()
        preferenceManager.sharedPreferences?.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(prefs: SharedPreferences?, key: String?) {
        if (key == themePreferenceKey) {
            ThemeUtils.updateTheme(prefs!!, key)
        }
    }

    @DrawableRes
    override fun onUiModeConfigChange(): Int {
        return when (requireContext().resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> R.drawable.ic_day_black_24dp
            Configuration.UI_MODE_NIGHT_YES -> R.drawable.ic_night_black_24dp
            else -> R.drawable.ic_day_black_24dp
        }
    }

    @DrawableRes
    override fun onPowerSaverModeChange(powerManager: PowerManager): Int {
        return if (powerManager.isPowerSaveMode) R.drawable.ic_night_black_24dp else R.drawable.ic_day_black_24dp
    }

    companion object {
        const val DEFAULT_THEME_VALUE = "Light"
    }
}
