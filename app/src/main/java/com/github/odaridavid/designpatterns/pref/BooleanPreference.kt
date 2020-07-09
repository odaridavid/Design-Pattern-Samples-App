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

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


internal class BooleanPreference(
    private val preferenceStore: IPreferenceStore,
    private val key: String
) : ReadWriteProperty<Any, Boolean> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean {
        return preferenceStore.getBoolean(key)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
        preferenceStore.setBoolean(key, value)
    }

}