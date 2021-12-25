package com.example.physicsexperiment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultTwoActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result02);

        initResult2();
    }

    public void initResult2(){

        //显示A类不确定度
        TextView textResultuAD = findViewById(R.id.textViewE21uAD);
        Double UAD = TwoActivity.database2.getUAD2();
        textResultuAD.setText(UAD.toString());

        //显示B类不确定度
        TextView textResultuBD = findViewById(R.id.textViewE21uBD);
        Double UBD = TwoActivity.database2.getUBD2();
        textResultuBD.setText(UBD.toString());

        //显示A类不确定度
        TextView textResultuAX = findViewById(R.id.textViewE21uAx);
        Double UAX = TwoActivity.database2.getUAX2();
        textResultuAX.setText(UAX.toString());

        //显示B类不确定度
        TextView textResultuBX = findViewById(R.id.textViewE21uBx);
        Double UBX = TwoActivity.database2.getUBX2();
        textResultuBX.setText(UBX.toString());

        //显示总不确定度
        TextView textResultuCX = findViewById(R.id.textViewE21uCx);
        Double UCX = TwoActivity.database2.getUCX2();
        textResultuCX.setText(UCX.toString());

        //显示A类不确定度
        TextView textResultuAH = findViewById(R.id.textViewE21uAH);
        Double UAH = TwoActivity.database2.getUAH2();
        textResultuAH.setText(UAH.toString());

        //显示B类不确定度
        TextView textResultuBH = findViewById(R.id.textViewE21uBH);
        Double UBH = TwoActivity.database2.getUBH2();
        textResultuBH.setText(UBH.toString());

        //显示总不确定度
        TextView textResultuCH = findViewById(R.id.textViewE21uCH);
        Double UCH = TwoActivity.database2.getUCH2();
        textResultuCH.setText(UCH.toString());

        //显示A类不确定度
        TextView textResultuAL = findViewById(R.id.textViewE21uAL);
        Double UAL = TwoActivity.database2.getUAL2();
        textResultuAL.setText(UAL.toString());

        //显示B类不确定度
        TextView textResultuBL = findViewById(R.id.textViewE21uBL);
        Double UBL = TwoActivity.database2.getUBL2();
        textResultuBL.setText(UBL.toString());

        //显示总不确定度
        TextView textResultuCL = findViewById(R.id.textViewE21uCL);
        Double UCL = TwoActivity.database2.getUCL2();
        textResultuCL.setText(UCL.toString());

        //显示A类不确定度
        TextView textResultuAb = findViewById(R.id.textViewE21uAb);
        Double UAb = TwoActivity.database2.getUAb2();
        textResultuAb.setText(UAb.toString());

        //显示B类不确定度
        TextView textResultuBb = findViewById(R.id.textViewE21uBb);
        Double UBb = TwoActivity.database2.getUBb2();
        textResultuBb.setText(UBb.toString());

        //显示总不确定度
        TextView textResultuCb = findViewById(R.id.textViewE21uCb);
        Double UCb = TwoActivity.database2.getUCb2();
        textResultuCb.setText(UCb.toString());

        //显示总不确定度
        TextView textResultuCl = findViewById(R.id.textViewE21uCl);
        Double UCl = TwoActivity.database2.getUCl2();
        textResultuCl.setText(UCl.toString());

        //E
        TextView textResultE = findViewById(R.id.textViewE21E);
        Double E = TwoActivity.database2.getAverageE2();
        textResultE.setText(E.toString());

        //uRE
        TextView textResultuRE = findViewById(R.id.textViewE21uRE);
        Double URE = TwoActivity.database2.getURE2();
        textResultuRE.setText(URE.toString());

        //uCE
        TextView textResultuCE = findViewById(R.id.textViewE21uCE);
        Double UCE = TwoActivity.database2.getUCE2();
        textResultuCE.setText(UCE.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
