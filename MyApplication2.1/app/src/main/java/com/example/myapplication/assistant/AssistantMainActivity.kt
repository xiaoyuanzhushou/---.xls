package com.example.myapplication.assistant

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.R
import com.example.myapplication.assistant.Acti.*


class AssistantMainActivity : AppCompatActivity() {
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
                    this@AssistantMainActivity,
                    OneActivity::class.java
                )
            )
        }
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            startActivity(
                Intent(
                    this@AssistantMainActivity,
                    TwoActivity::class.java
                )
            )

        }
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            startActivity(
                Intent(
                    this@AssistantMainActivity,
                    Activity03::class.java
                )
            )

        }
        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            startActivity(
                Intent(
                    this@AssistantMainActivity,
                    Activity04::class.java
                )
            )
        }
        val button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            startActivity(
                Intent(
                    this@AssistantMainActivity,
                    Activity06::class.java
                )
            )
        }
        val button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {   startActivity(
            Intent(
                this@AssistantMainActivity,
                Activity07::class.java
            )
        )}
        val button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener {   startActivity(
            Intent(
                this@AssistantMainActivity,
                Activity08::class.java
            )
        )}
        val button8 = findViewById<Button>(R.id.button8)
        button8.setOnClickListener {
            startActivity(
                Intent(
                    this@AssistantMainActivity,
                    Activity09::class.java
                )
            )
        }
        val button9 = findViewById<Button>(R.id.button9)
        button9.setOnClickListener {
            startActivity(
                Intent(
                    this@AssistantMainActivity,
                    Activity10::class.java
                )
            )
        }
        val button10 = findViewById<Button>(R.id.button10)
        button10.setOnClickListener {
            startActivity(
                Intent(
                    this@AssistantMainActivity,
                    Activity11::class.java
                )
            )
        }
        val button11 = findViewById<Button>(R.id.button11)
        button11.setOnClickListener {
            startActivity(
                Intent(
                    this@AssistantMainActivity,
                    Activity12::class.java
                )
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        private const val REQUEST_CODE_ADD = 1002
        private const val REQUEST_CODE_SORT = 1003
    }
}