/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.github.odaridavid.designpatterns.helpers

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.github.odaridavid.designpatterns.R
import us.feras.mdv.MarkdownView


inline fun <reified T> Activity.navigateTo(noinline intentExtras: ((Intent) -> Unit)? = null) {
    val intent = Intent(this, T::class.java)
    intentExtras?.run {
        intentExtras(intent)
    }
    startActivity(intent)
}

internal fun MarkdownView.loadWithKotlinCss(context: Context, filePath: String) {
    loadMarkdownFile(
        filePath,
        getThemedCss(context)
    )
}

internal fun getThemedCss(context: Context): String {
    val sp = PreferenceManager.getDefaultSharedPreferences(context)
    return when (getCurrentTheme(context, sp)) {
        ThemeUtils.THEME_DARK -> DARK_KOTLIN_CSS_PATH
        ThemeUtils.THEME_LIGHT -> LIGHT_KOTLIN_CSS_PATH
        ThemeUtils.THEME_SYSTEM -> LIGHT_KOTLIN_CSS_PATH
        else -> LIGHT_KOTLIN_CSS_PATH
    }
}

internal fun getCurrentTheme(context: Context, sp: SharedPreferences?): String {
    return sp?.getString(context.getString(R.string.key_theme_preference), ThemeUtils.THEME_LIGHT)
        ?: "default"
}

internal fun String.checkUrlScheme(): String {
    return if (!startsWith("http://") && !startsWith("https://"))
        "http://$this"
    else this
}

internal fun Activity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}