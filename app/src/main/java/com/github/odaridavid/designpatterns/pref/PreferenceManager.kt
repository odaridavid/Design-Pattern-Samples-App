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


internal interface IPreferenceManager : RatingPreferenceManager

interface RatingPreferenceManager {
    var hasRated: Boolean
    var ratingPromptCount: Int
}

internal class PreferenceManager(preferencesStore: PreferencesStore) : IPreferenceManager {

    override var hasRated: Boolean by BooleanPreference(preferencesStore, PREF_HAS_RATED)

    override var ratingPromptCount: Int by IntPreference(preferencesStore, PREF_RATING_PROMPT_COUNT)

    companion object {
        private const val PREF_HAS_RATED = "rating"
        private const val PREF_RATING_PROMPT_COUNT = "rating_prompt"
    }

}