package com.github.odaridavid.designpatterns.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.odaridavid.designpatterns.helpers.navigateTo

internal class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateTo<MainActivity>()
        finish()
    }
}
