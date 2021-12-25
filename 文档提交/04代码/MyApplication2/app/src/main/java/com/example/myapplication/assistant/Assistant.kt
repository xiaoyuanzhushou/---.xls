package com.example.myapplication.assistant

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.R

class Assistant : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        val toolbar = findViewById<Toolbar>(R.id.baseToolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(R.color.teal_200)
        initButtons()
    }

    private fun initButtons() {
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            startActivity(
                Intent(
                    this@Assistant,
                    OneActivity::class.java
                )
            )
        }
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener { }
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener { }
        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener { }

        val button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener { }
        val button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener { }
        val button8 = findViewById<Button>(R.id.button8)
        button8.setOnClickListener { }
        val button9 = findViewById<Button>(R.id.button9)
        button9.setOnClickListener { }
        val button10 = findViewById<Button>(R.id.button10)
        button10.setOnClickListener { }
        val button11 = findViewById<Button>(R.id.button11)
        button11.setOnClickListener { }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        private const val REQUEST_CODE_ADD = 1002
        private const val REQUEST_CODE_SORT = 1003
    }
}