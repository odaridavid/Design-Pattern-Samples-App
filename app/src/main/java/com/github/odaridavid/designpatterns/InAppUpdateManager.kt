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

import android.content.Context
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.firebase.Firebase
import com.google.firebase.crashlytics.crashlytics

internal interface UpdateManager {
    fun checkForUpdate(
        context: Context,
        activityResultLauncher: ActivityResultLauncher<IntentSenderRequest>
    )
}

internal object InAppUpdateManager : UpdateManager {

    override fun checkForUpdate(
        context: Context,
        activityResultLauncher: ActivityResultLauncher<IntentSenderRequest>
    ) {
        val appUpdateManager: AppUpdateManager = AppUpdateManagerFactory.create(context)
        val appUpdateInfo = appUpdateManager.appUpdateInfo
        appUpdateInfo.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                handleUpdateImmediately(appUpdateManager, task.result, activityResultLauncher)
            } else {
                Firebase.crashlytics.log("Failed to check for update")
            }
        }
    }

    private fun handleUpdateImmediately(
        appUpdateManager: AppUpdateManager,
        appUpdateInfo: AppUpdateInfo,
        activityResultLauncher: ActivityResultLauncher<IntentSenderRequest>,
    ) {
        val updateAvailability = appUpdateInfo.updateAvailability()
        if ((updateAvailability == UpdateAvailability.UPDATE_AVAILABLE || updateAvailability == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) &&
            appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
        ) {
            appUpdateManager.startUpdateFlowForResult(
                appUpdateInfo,
                activityResultLauncher,
                AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build()
            )
        }
    }
}
