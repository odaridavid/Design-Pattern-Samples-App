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
package com.github.odaridavid.designpatterns

import android.app.Application
import androidx.preference.PreferenceManager
import com.github.odaridavid.designpatterns.helpers.ThemeUtils


internal class DesignPatternsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val sp = PreferenceManager.getDefaultSharedPreferences(baseContext)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
        ThemeUtils.updateTheme(sp, getString(R.string.key_theme_preference))
    }

}