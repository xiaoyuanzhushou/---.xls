package com.example.myapplication.xuefenji

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.R

class MainActivityXuefenji : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_xuefenji)
        val button1: Button = findViewById(R.id.button1)

        val et: EditText = findViewById(R.id.et)

        button1.setOnClickListener{
            Toast.makeText(this, "You click Button1", Toast.LENGTH_LONG).show()

            val input = et.text.toString()

            val bundle = Bundle()

            bundle.putString("String", input)

            val intent = Intent(this, ScoreActivity::class.java)

            intent.putExtras(bundle)

            startActivity(intent)


        }
    }
}