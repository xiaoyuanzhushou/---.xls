package com.nwpu.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button11: Button = findViewById(R.id.button11)
        button11.setOnClickListener{
            Toast.makeText(applicationContext, "自己慢慢算吧", Toast.LENGTH_LONG).show()
        }

    }
}