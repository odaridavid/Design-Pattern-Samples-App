/*
*
* Copyright 2020 David Odari
*
* Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except 
* in compliance with the License. You may obtain a copy of the License at
*
*          http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software distributed under the License 
* is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
* or implied. See the License for the specific language governing permissions and limitations under
* the License.
*
*/
package com.github.odaridavid.designpatterns.pref

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit


internal interface IPreferenceStore : IntStore, BooleanStore

internal interface IntStore {

    fun setInt(key: String, value: Int)

    fun getInt(key: String): Int
}

internal interface BooleanStore {

    fun setBoolean(key: String, value: Boolean)

    fun getBoolean(key: String): Boolean
}

internal class PreferencesStore(private val context: Context) : IPreferenceStore {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    override fun setInt(key: String, value: Int) {
        setPreference { putInt(key, value) }
    }

    override fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, DEFAULT_INT_VALUE)
    }

    override fun setBoolean(key: String, value: Boolean) {
        setPreference { putBoolean(key, value) }
    }

    override fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, DEFAULT_BOOLEAN_VALUE)
    }

    private inline fun setPreference(crossinline block: SharedPreferences.Editor.() -> (Unit)) {
        sharedPreferences.edit { block() }
    }

    companion object {
        private const val PREF_NAME = "design_patterns_pref"
        const val DEFAULT_INT_VALUE = -1
        const val DEFAULT_BOOLEAN_VALUE = false
    }

}