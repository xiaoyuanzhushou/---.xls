package com.example.myapplication.assistant

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class ResultOneActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result01)
        initResult1()
        initResult12()
    }

    fun initResult1() {
        //显示A类不确定度
        val textResultuAL = findViewById<TextView>(R.id.textViewE11uAL)
        val UAL: Double = OneActivity.database11.uAL1
        textResultuAL.text = UAL.toString()

        //显示B类不确定度
        val textResultuBL = findViewById<TextView>(R.id.textViewE11uBL)
        val UBL: Double = OneActivity.database11.uBL1
        textResultuBL.text = UBL.toString()

        //显示总不确定度
        val textResultuL = findViewById<TextView>(R.id.textViewE11uL)
        val UL: Double = OneActivity.database11.uCL1
        textResultuL.text = UL.toString()

        //显示lambda不确定度
        val textResultulL = findViewById<TextView>(R.id.textViewE11uλ)
        val UlL: Double = OneActivity.database11.uLambda1
        textResultulL.text = UlL.toString()

        //显示V的不确定度
        val textResultuV = findViewById<TextView>(R.id.textViewE11uV)
        val UV: Double = OneActivity.database11.uV1
        textResultuV.text = UV.toString()

        //显示温度为t时空气中的声速
        val textResultVt = findViewById<TextView>(R.id.textViewE11Vt)
        val VT: Double = OneActivity.database11.Vt1
        textResultVt.text = VT.toString()

        //显示相对误差
        val textResultE = findViewById<TextView>(R.id.textViewE11E)
        val E: Double = OneActivity.database11.E1
        textResultE.text = E.toString()
    }

    fun initResult12() {
        //显示A类不确定度
        val textResultuAL = findViewById<TextView>(R.id.textViewE12uAL)
        val UAL: Double = OneActivity.database12.uAL1
        textResultuAL.text = UAL.toString()

        //显示B类不确定度
        val textResultuBL = findViewById<TextView>(R.id.textViewE12uBL)
        val UBL: Double = OneActivity.database12.uBL1
        textResultuBL.text = UBL.toString()

        //显示总不确定度
        val textResultuL = findViewById<TextView>(R.id.textViewE12uL)
        val UL: Double = OneActivity.database12.uCL1
        textResultuL.text = UL.toString()

        //显示lambda不确定度
        val textResultulL = findViewById<TextView>(R.id.textViewE12uλ)
        val UlL: Double = OneActivity.database12.uLambda1
        textResultulL.text = UlL.toString()

        //显示V的不确定度
        val textResultuV = findViewById<TextView>(R.id.textViewE12uV)
        val UV: Double = OneActivity.database12.uV1
        textResultuV.text = UV.toString()

        //显示温度为t时空气中的声速
        val textResultVt = findViewById<TextView>(R.id.textViewE12Vt)
        val VT: Double = OneActivity.database12.Vt1
        textResultVt.text = VT.toString()

        //显示相对误差
        val textResultE = findViewById<TextView>(R.id.textViewE12E)
        val E: Double = OneActivity.database12.E1
        textResultE.text = E.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
