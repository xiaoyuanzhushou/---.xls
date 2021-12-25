package com.example.myapplication.assistant

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.assistant.OneActivity

class ResultTwoActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result02)
        initResult2()
    }

    fun initResult2() {

        //显示A类不确定度
        val textResultuAD = findViewById<TextView>(R.id.textViewE21uAD)
        val UAD: Double = OneActivity.database2.uAD2
        textResultuAD.text = UAD.toString()

        //显示B类不确定度
        val textResultuBD = findViewById<TextView>(R.id.textViewE21uBD)
        val UBD: Double = OneActivity.database2.uBD2
        textResultuBD.text = UBD.toString()

        //显示A类不确定度
        val textResultuAX = findViewById<TextView>(R.id.textViewE21uAx)
        val UAX: Double = OneActivity.database2.uAX2
        textResultuAX.text = UAX.toString()

        //显示B类不确定度
        val textResultuBX = findViewById<TextView>(R.id.textViewE21uBx)
        val UBX: Double = OneActivity.database2.uBX2
        textResultuBX.text = UBX.toString()

        //显示总不确定度
        val textResultuCX = findViewById<TextView>(R.id.textViewE21uCx)
        val UCX: Double = OneActivity.database2.uCX2
        textResultuCX.text = UCX.toString()

        //显示A类不确定度
        val textResultuAH = findViewById<TextView>(R.id.textViewE21uAH)
        val UAH: Double = OneActivity.database2.uAH2
        textResultuAH.text = UAH.toString()

        //显示B类不确定度
        val textResultuBH = findViewById<TextView>(R.id.textViewE21uBH)
        val UBH: Double = OneActivity.database2.uBH2
        textResultuBH.text = UBH.toString()

        //显示总不确定度
        val textResultuCH = findViewById<TextView>(R.id.textViewE21uCH)
        val UCH: Double = OneActivity.database2.uCH2
        textResultuCH.text = UCH.toString()

        //显示A类不确定度
        val textResultuAL = findViewById<TextView>(R.id.textViewE21uAL)
        val UAL: Double = OneActivity.database2.uAL2
        textResultuAL.text = UAL.toString()

        //显示B类不确定度
        val textResultuBL = findViewById<TextView>(R.id.textViewE21uBL)
        val UBL: Double = OneActivity.database2.uBL2
        textResultuBL.text = UBL.toString()

        //显示总不确定度
        val textResultuCL = findViewById<TextView>(R.id.textViewE21uCL)
        val UCL: Double = OneActivity.database2.uCL2
        textResultuCL.text = UCL.toString()

        //显示A类不确定度
        val textResultuAb = findViewById<TextView>(R.id.textViewE21uAb)
        val UAb: Double = OneActivity.database2.uAb2
        textResultuAb.text = UAb.toString()

        //显示B类不确定度
        val textResultuBb = findViewById<TextView>(R.id.textViewE21uBb)
        val UBb: Double = OneActivity.database2.uBb2
        textResultuBb.text = UBb.toString()

        //显示总不确定度
        val textResultuCb = findViewById<TextView>(R.id.textViewE21uCb)
        val UCb: Double = OneActivity.database2.uCb2
        textResultuCb.text = UCb.toString()

        //显示总不确定度
        val textResultuCl = findViewById<TextView>(R.id.textViewE21uCl)
        val UCl: Double = OneActivity.database2.uCL2
        textResultuCl.text = UCl.toString()

        //E
        val textResultE = findViewById<TextView>(R.id.textViewE21E)
        val E: Double = OneActivity.database2.averageE2
        textResultE.text = E.toString()

        //uRE
        val textResultuRE = findViewById<TextView>(R.id.textViewE21uRE)
        val URE: Double = OneActivity.database2.uRE2
        textResultuRE.text = URE.toString()

        //uCE
        val textResultuCE = findViewById<TextView>(R.id.textViewE21uCE)
        val UCE: Double = OneActivity.database2.uCE2
        textResultuCE.text = UCE.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
