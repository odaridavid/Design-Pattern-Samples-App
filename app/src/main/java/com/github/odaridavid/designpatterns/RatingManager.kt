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

import android.content.SharedPreferences

internal interface IRatingManager {
    fun hasGivenRating(): Boolean
    fun shouldPromptForRating(): Boolean
    fun updatePromptForRatingCounter()
    fun giveRating()
}

class RatingManager(private val sharedPreferences: SharedPreferences) :
    IRatingManager {

    override fun hasGivenRating(): Boolean = sharedPreferences.getBoolean(RATING_PREF_KEY, false)

    override fun giveRating() {
        with(sharedPreferences.edit()) {
            putBoolean(RATING_PREF_KEY, true)
            apply()
        }
    }

    override fun shouldPromptForRating(): Boolean {
        val counter = sharedPreferences.getInt(PROMPT_COUNTER_PREF_KEY, 0)
        return counter % 5 == 0
    }

    override fun updatePromptForRatingCounter() {
        val counter = sharedPreferences.getInt(PROMPT_COUNTER_PREF_KEY, 0) + 1
        with(sharedPreferences.edit()) {
            putInt(PROMPT_COUNTER_PREF_KEY, counter)
            apply()
        }
    }

    companion object {
        private const val RATING_PREF_KEY = "rating"
        private const val PROMPT_COUNTER_PREF_KEY = "rating_prompt"
    }
}