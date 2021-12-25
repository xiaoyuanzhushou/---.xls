package com.example.myapplication.assistant
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.assistant.OneActivity
import com.example.myapplication.assistant.ResultTwoActivity

class TwoActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.experiment02)
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            initDatas2()
            startActivity(
                Intent(
                    this@TwoActivity,
                    ResultTwoActivity::class.java
                )
            )
        }
    }

    fun initDatas2() {

        //获取aup1
        val textaup1 = findViewById<TextView>(R.id.E21aup1)
        val aup1 = textaup1.text.toString().toDouble()

        //aup2
        val textaup2 = findViewById<TextView>(R.id.E21aup2)
        val aup2 = textaup2.text.toString().toDouble()

        //aup3
        val textaup3 = findViewById<TextView>(R.id.E21aup3)
        val aup3 = textaup3.text.toString().toDouble()

        //aup4
        val textaup4 = findViewById<TextView>(R.id.E21aup4)
        val aup4 = textaup4.text.toString().toDouble()

        //aup5
        val textaup5 = findViewById<TextView>(R.id.E21aup5)
        val aup5 = textaup5.text.toString().toDouble()

        //aup6
        val textaup6 = findViewById<TextView>(R.id.E21aup6)
        val aup6 = textaup6.text.toString().toDouble()

        //aup7
        val textaup7 = findViewById<TextView>(R.id.E21aup7)
        val aup7 = textaup7.text.toString().toDouble()

        //aup8
        val textaup8 = findViewById<TextView>(R.id.E21aup8)
        val aup8 = textaup8.text.toString().toDouble()

        //adown1
        val textadown1 = findViewById<TextView>(R.id.E21adown1)
        val adown1 = textadown1.text.toString().toDouble()

        //adown2
        val textadown2 = findViewById<TextView>(R.id.E21adown2)
        val adown2 = textadown2.text.toString().toDouble()

        //adown3
        val textadown3 = findViewById<TextView>(R.id.E21adown3)
        val adown3 = textadown3.text.toString().toDouble()

        //adown4
        val textadown4 = findViewById<TextView>(R.id.E21adown4)
        val adown4 = textadown4.text.toString().toDouble()

        //adown5
        val textadown5 = findViewById<TextView>(R.id.E21adown5)
        val adown5 = textadown5.text.toString().toDouble()

        //adown6
        val textadown6 = findViewById<TextView>(R.id.E21adown6)
        val adown6 = textadown6.text.toString().toDouble()

        //adown7
        val textadown7 = findViewById<TextView>(R.id.E21adown7)
        val adown7 = textadown7.text.toString().toDouble()

        //adown8
        val textadown8 = findViewById<TextView>(R.id.E21adown8)
        val adown8 = textadown8.text.toString().toDouble()

        //D1
        val textD1 = findViewById<TextView>(R.id.E22D11)
        val D1 = textD1.text.toString().toDouble()

        //D2
        val textD2 = findViewById<TextView>(R.id.E22D12)
        val D2 = textD2.text.toString().toDouble()

        //D3
        val textD3 = findViewById<TextView>(R.id.E22D13)
        val D3 = textD3.text.toString().toDouble()

        //D4
        val textD4 = findViewById<TextView>(R.id.E22D14)
        val D4 = textD4.text.toString().toDouble()

        //D5
        val textD5 = findViewById<TextView>(R.id.E22D15)
        val D5 = textD5.text.toString().toDouble()

        //D6
        val textD6 = findViewById<TextView>(R.id.E22D16)
        val D6 = textD6.text.toString().toDouble()

        //D7
        val textD7 = findViewById<TextView>(R.id.E22D17)
        val D7 = textD7.text.toString().toDouble()

        //D8
        val textD8 = findViewById<TextView>(R.id.E22D18)
        val D8 = textD8.text.toString().toDouble()

        //D9
        val textD9 = findViewById<TextView>(R.id.E22D19)
        val D9 = textD9.text.toString().toDouble()

        //D10
        val textD10 = findViewById<TextView>(R.id.E22D110)
        val D10 = textD10.text.toString().toDouble()

        //X1up1
        val textX1up1 = findViewById<TextView>(R.id.E23X1up1)
        val X1up1 = textX1up1.text.toString().toDouble()

        //X1up2
        val textX1up2 = findViewById<TextView>(R.id.E23X1up2)
        val X1up2 = textX1up2.text.toString().toDouble()

        //X1up3
        val textX1up3 = findViewById<TextView>(R.id.E23X1up3)
        val X1up3 = textX1up3.text.toString().toDouble()

        //X1up4
        val textX1up4 = findViewById<TextView>(R.id.E23X1up4)
        val X1up4 = textX1up4.text.toString().toDouble()

        //X1up5
        val textX1up5 = findViewById<TextView>(R.id.E23X1up5)
        val X1up5 = textX1up5.text.toString().toDouble()

        //X1down1
        val textX1down1 = findViewById<TextView>(R.id.E23X1down1)
        val X1down1 = textX1down1.text.toString().toDouble()

        //X1down2
        val textX1down2 = findViewById<TextView>(R.id.E23X1down2)
        val X1down2 = textX1down2.text.toString().toDouble()

        //X1down3
        val textX1down3 = findViewById<TextView>(R.id.E23X1down3)
        val X1down3 = textX1down3.text.toString().toDouble()

        //X1down4
        val textX1down4 = findViewById<TextView>(R.id.E23X1down4)
        val X1down4 = textX1down4.text.toString().toDouble()

        //X1down5
        val textX1down5 = findViewById<TextView>(R.id.E23X1down5)
        val X1down5 = textX1down5.text.toString().toDouble()

        //b1
        val textb1 = findViewById<TextView>(R.id.E23b1)
        val b1 = textb1.text.toString().toDouble()

        //b2
        val textb2 = findViewById<TextView>(R.id.E23b2)
        val b2 = textb2.text.toString().toDouble()

        //b3
        val textb3 = findViewById<TextView>(R.id.E23b3)
        val b3 = textb3.text.toString().toDouble()

        //b4
        val textb4 = findViewById<TextView>(R.id.E23b4)
        val b4 = textb4.text.toString().toDouble()

        //b5
        val textb5 = findViewById<TextView>(R.id.E23b5)
        val b5 = textb5.text.toString().toDouble()

        //L
        val textL = findViewById<TextView>(R.id.E23L)
        val L = textL.text.toString().toDouble()
        val aup = arrayOf(aup1, aup2, aup3, aup4, aup5, aup6, aup7, aup8)
        val adown = arrayOf(adown1, adown2, adown3, adown4, adown5, adown6, adown7, adown8)
        val D = arrayOf(D1, D2, D3, D4, D5, D6, D7, D8, D9, D10)
        val X1up = arrayOf(X1up1, X1up2, X1up3, X1up4, X1up5)
        val X1down = arrayOf(X1down1, X1down2, X1down3, X1down4, X1down5)
        val b = arrayOf(b1, b2, b3, b4, b5)
        OneActivity.database2.aUp=aup
        OneActivity.database2.aDown = adown
        OneActivity.database2.D=D
        OneActivity.database2.X1=X1up
        OneActivity.database2.X2=X1down
        OneActivity.database2.b=b
        OneActivity.database2.L=L
        OneActivity.database2.dataProcess()
    }
}
