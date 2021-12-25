package com.example.myapplication.assistant

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.assistant.beans.Database1
import com.example.myapplication.assistant.result.ResultOneActivity
import java.util.*


class OneActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ASSISTANT)
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            initDatas1()
            initDatas12()
            startActivity(Intent(this@OneActivity, ResultOneActivity::class.java))
        }

        /*Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    fun initDatas1() {
        val textf = findViewById<TextView>(R.id.E11f)
        val f = textf.text.toString().toInt()

        //获取室温t
        val textt = findViewById<TextView>(R.id.E11t)
        val t = textt.text.toString().toInt()

        //获取数据1
        val text1 = findViewById<TextView>(R.id.E11Xi1)
        val xi1 = text1.text.toString().toInt()

        //2
        val text2 = findViewById<TextView>(R.id.E11Xi2)
        val xi2 = text2.text.toString().toInt()

        //3
        val text3 = findViewById<TextView>(R.id.E11Xi3)
        val xi3 = text3.text.toString().toInt()

        //4
        val text4 = findViewById<TextView>(R.id.E11Xi4)
        val xi4 = text4.text.toString().toInt()

        //5
        val text5 = findViewById<TextView>(R.id.E11Xi5)
        val xi5 = text5.text.toString().toInt()

        //6
        val text6 = findViewById<TextView>(R.id.E11Xi6)
        val xi6 = text6.text.toString().toInt()

        //7
        val text7 = findViewById<TextView>(R.id.E11Xi7)
        val xi7 = text7.text.toString().toInt()

        //8
        val text8 = findViewById<TextView>(R.id.E11Xi8)
        val xi8 = text8.text.toString().toInt()

        //9
        val text9 = findViewById<TextView>(R.id.E11Xi9)
        val xi9 = text9.text.toString().toInt()

        //10
        val text10 = findViewById<TextView>(R.id.E11Xi10)
        val xi10 = text10.text.toString().toInt()
        val a = arrayOf(xi1, xi2, xi3, xi4, xi5, xi6, xi7, xi8, xi9, xi10)
        database11.f = f
        database11.t = t
        database11.Xi = Arrays.asList(*a)
        database11.dataProcess()
    }

    fun initDatas12() {
        val textf = findViewById<TextView>(R.id.E12f)
        val f = textf.text.toString().toInt()

        //获取室温t
        val textt = findViewById<TextView>(R.id.E12t)
        val t = textt.text.toString().toInt()

        //获取数据1
        val text1 = findViewById<TextView>(R.id.E12Xi1)
        val xi1 = text1.text.toString().toInt()

        //2
        val text2 = findViewById<TextView>(R.id.E12Xi2)
        val xi2 = text2.text.toString().toInt()

        //3
        val text3 = findViewById<TextView>(R.id.E12Xi3)
        val xi3 = text3.text.toString().toInt()

        //4
        val text4 = findViewById<TextView>(R.id.E12Xi4)
        val xi4 = text4.text.toString().toInt()

        //5
        val text5 = findViewById<TextView>(R.id.E12Xi5)
        val xi5 = text5.text.toString().toInt()

        //6
        val text6 = findViewById<TextView>(R.id.E12Xi6)
        val xi6 = text6.text.toString().toInt()

        //7
        val text7 = findViewById<TextView>(R.id.E12Xi7)
        val xi7 = text7.text.toString().toInt()

        //8
        val text8 = findViewById<TextView>(R.id.E12Xi8)
        val xi8 = text8.text.toString().toInt()

        //9
        val text9 = findViewById<TextView>(R.id.E12Xi9)
        val xi9 = text9.text.toString().toInt()

        //10
        val text10 = findViewById<TextView>(R.id.E12Xi10)
        val xi10 = text10.text.toString().toInt()
        val a = arrayOf(xi1, xi2, xi3, xi4, xi5, xi6, xi7, xi8, xi9, xi10)
        database12.f = f
        database12.t = t
        database12.Xi = Arrays.asList(*a)
        database12.dataProcess()
    }

    /*public void initDatas2(){

        //aup1
        TextView textaup1 = findViewById(R.id.E21aup1);
        double aup1 = Double.parseDouble(textaup1.getText().toString());

        //aup2
        TextView textaup2 = findViewById(R.id.E21aup2);
        double aup2 = Double.parseDouble(textaup2.getText().toString());

        //aup3
        TextView textaup3 = findViewById(R.id.E21aup3);
        double aup3 = Double.parseDouble(textaup3.getText().toString());

        //aup4
        TextView textaup4 = findViewById(R.id.E21aup4);
        double aup4 = Double.parseDouble(textaup4.getText().toString());

        //aup5
        TextView textaup5 = findViewById(R.id.E21aup5);
        double aup5 = Double.parseDouble(textaup5.getText().toString());

        //aup6
        TextView textaup6 = findViewById(R.id.E21aup6);
        double aup6 = Double.parseDouble(textaup6.getText().toString());

        //aup7
        TextView textaup7 = findViewById(R.id.E21aup7);
        double aup7 = Double.parseDouble(textaup7.getText().toString());

        //aup1
        TextView textaup8 = findViewById(R.id.E21aup8);
        double aup8 = Double.parseDouble(textaup8.getText().toString());

    }*/
    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        var database11 = Database1()
        var database12 = Database1()
    }
}