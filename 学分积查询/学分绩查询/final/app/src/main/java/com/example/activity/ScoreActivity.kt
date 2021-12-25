package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.parse_service.ScoreService
import com.example.parse_service.ScoreService.getScore
import org.w3c.dom.Text
import javax.crypto.SecretKey

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_score)

        val textView: TextView = findViewById(R.id.textView)

        val bundle = intent.extras

        val string = bundle?.getString("String")

        val scores = getScore(string.toString())

        textView.text = scores.toString()
    }
}