package com.github.odaridavid.designpatterns.factory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.BaseActivity

class FactoryActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factory)
    }
}
