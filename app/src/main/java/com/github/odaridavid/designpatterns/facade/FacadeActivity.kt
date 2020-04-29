package com.github.odaridavid.designpatterns.facade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.BaseActivity

class FacadeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facade)
    }
}
