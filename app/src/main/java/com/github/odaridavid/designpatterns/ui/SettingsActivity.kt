package com.github.odaridavid.designpatterns.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.BaseActivity

internal class SettingsActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
}

