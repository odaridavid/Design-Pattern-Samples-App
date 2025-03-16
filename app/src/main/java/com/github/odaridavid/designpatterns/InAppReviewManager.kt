package com.github.odaridavid.designpatterns

import android.app.Activity
import com.google.android.play.core.review.ReviewException
import com.google.android.play.core.review.ReviewManagerFactory
import com.google.firebase.Firebase
import com.google.firebase.crashlytics.crashlytics

class InAppReviewManager() {

    fun requestAndLaunchReview(activity: Activity) {
        val manager = ReviewManagerFactory.create(activity.applicationContext)
        manager.requestReviewFlow().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                manager.launchReviewFlow(activity, task.result)
                    .addOnFailureListener { Firebase.crashlytics.log("Review flow launch failed: ${it.message}") }
            } else {
                val errorCode = (task.exception as? ReviewException)?.errorCode
                Firebase.crashlytics.log("Review request failed: $errorCode")
            }
        }
    }
}
