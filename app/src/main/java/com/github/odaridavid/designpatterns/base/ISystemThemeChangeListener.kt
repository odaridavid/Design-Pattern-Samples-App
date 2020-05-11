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
package com.github.odaridavid.designpatterns.base

import android.os.PowerManager

/**
 * Listener for system initiated changes that affect how the ui will be rendered.
 * @param T expected output from system initiated change
 */
interface ISystemThemeChangeListener<out T> {
    /**
     * Called when there's a change in power saver settings
     *
     * @param powerManager an instance of PowerManager for power saver related operations
     */
    fun onPowerSaverModeChange(powerManager: PowerManager): T

    /**
     * Called when there's a change in theme initiated by the system
     * e.g Changing theme from the notification tray on Android Q and above
     */
    fun onUiModeConfigChange(): T
}