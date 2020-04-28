package com.github.odaridavid.designpatterns.abstractfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.BaseActivity

class AbstractFactoryActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abstract_factory)
    }
}
