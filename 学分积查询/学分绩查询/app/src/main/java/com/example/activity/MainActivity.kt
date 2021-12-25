package com.example.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.parse_service.ScoreService
import com.example.scoredata.DegreeData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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


// 打开系统的文件选择器
//    fun pickFile(view: View)
//    {
//        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT);
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        intent.setType("*/*");
//        this.startActivityForResult(intent, REQUEST_CODE);
//
//
//
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_test, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.add_item -> Toast.makeText(this, "You clicked Add",
                                    Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove",
                Toast.LENGTH_SHORT).show()
        }

        return true
    }

}