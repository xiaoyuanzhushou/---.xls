package com.example.xiaoyuanzhushou.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.xiaoyuanzhushou.courseTable.tools.UpdateUtils

import kotlinx.coroutines.launch
import splitties.activities.start

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            UpdateUtils.tranOldData(applicationContext)
            start<HomeFragment>()
            //startActivity<SudaLifeActivity>("type" to "澡堂")
            finish()
        }
    }

    override fun onBackPressed() {

    }
}
