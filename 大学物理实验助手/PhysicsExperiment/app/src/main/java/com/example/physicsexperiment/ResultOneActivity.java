package com.example.physicsexperiment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultOneActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result01);

        initResult1();
        initResult2();

    }

    public void initResult1(){
        //显示A类不确定度
        TextView textResultuAL = findViewById(R.id.textViewE11uAL);
        Double UAL = OneActivity.database11.getUAL1();
        textResultuAL.setText(UAL.toString());

        //显示B类不确定度
        TextView textResultuBL = findViewById(R.id.textViewE11uBL);
        Double UBL = OneActivity.database11.getUBL1();
        textResultuBL.setText(UBL.toString());

        //显示总不确定度
        TextView textResultuL = findViewById(R.id.textViewE11uL);
        Double UL = OneActivity.database11.getUCL1();
        textResultuL.setText(UL.toString());

        //显示lambda不确定度
        TextView textResultulL = findViewById(R.id.textViewE11uλ);
        Double UlL = OneActivity.database11.getULambda1();
        textResultulL.setText(UlL.toString());

        //显示V的不确定度
        TextView textResultuV = findViewById(R.id.textViewE11uV);
        Double UV = OneActivity.database11.getUV1();
        textResultuV.setText(UV.toString());

        //显示温度为t时空气中的声速
        TextView textResultVt = findViewById(R.id.textViewE11Vt);
        Double VT = OneActivity.database11.getVt1();
        textResultVt.setText(VT.toString());

        //显示相对误差
        TextView textResultE = findViewById(R.id.textViewE11E);
        Double E = OneActivity.database11.getE1();
        textResultE.setText(E.toString());

    }

    public void initResult2(){
        //显示A类不确定度
        TextView textResultuAL = findViewById(R.id.textViewE12uAL);
        Double UAL = OneActivity.database12.getUAL1();
        textResultuAL.setText(UAL.toString());

        //显示B类不确定度
        TextView textResultuBL = findViewById(R.id.textViewE12uBL);
        Double UBL = OneActivity.database12.getUBL1();
        textResultuBL.setText(UBL.toString());

        //显示总不确定度
        TextView textResultuL = findViewById(R.id.textViewE12uL);
        Double UL = OneActivity.database12.getUCL1();
        textResultuL.setText(UL.toString());

        //显示lambda不确定度
        TextView textResultulL = findViewById(R.id.textViewE12uλ);
        Double UlL = OneActivity.database12.getULambda1();
        textResultulL.setText(UlL.toString());

        //显示V的不确定度
        TextView textResultuV = findViewById(R.id.textViewE12uV);
        Double UV = OneActivity.database12.getUV1();
        textResultuV.setText(UV.toString());

        //显示温度为t时空气中的声速
        TextView textResultVt = findViewById(R.id.textViewE12Vt);
        Double VT = OneActivity.database12.getVt1();
        textResultVt.setText(VT.toString());

        //显示相对误差
        TextView textResultE = findViewById(R.id.textViewE12E);
        Double E = OneActivity.database12.getE1();
        textResultE.setText(E.toString());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
