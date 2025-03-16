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

import android.content.Context
import com.github.odaridavid.designpatterns.pref.PreferenceManager
import com.github.odaridavid.designpatterns.pref.PreferencesStore


internal object InjectorUtils {

    fun providePreferenceManager(context: Context): PreferenceManager {
        val preferencesStore = PreferencesStore(context)
        return PreferenceManager(preferencesStore)
    }
}
