package com.example.physicsexperiment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TwoActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initDatas2();
                startActivity(new Intent(TwoActivity.this,
                        ResultTwoActivity.class));
            }
        });
    }

    public void initDatas2(){

        //获取aup1
        TextView textaup1 = findViewById(R.id.E21aup1);
        Double aup1 = Double.parseDouble(textaup1.getText().toString());

        //aup2
        TextView textaup2 = findViewById(R.id.E21aup2);
        Double aup2 = Double.parseDouble(textaup2.getText().toString());

        //aup3
        TextView textaup3 = findViewById(R.id.E21aup3);
        Double aup3 = Double.parseDouble(textaup3.getText().toString());

        //aup4
        TextView textaup4 = findViewById(R.id.E21aup4);
        Double aup4 = Double.parseDouble(textaup4.getText().toString());

        //aup5
        TextView textaup5 = findViewById(R.id.E21aup5);
        Double aup5 = Double.parseDouble(textaup5.getText().toString());

        //aup6
        TextView textaup6 = findViewById(R.id.E21aup6);
        Double aup6 = Double.parseDouble(textaup6.getText().toString());

        //aup7
        TextView textaup7 = findViewById(R.id.E21aup7);
        Double aup7 = Double.parseDouble(textaup7.getText().toString());

        //aup8
        TextView textaup8 = findViewById(R.id.E21aup8);
        Double aup8 = Double.parseDouble(textaup8.getText().toString());

        //adown1
        TextView textadown1 = findViewById(R.id.E21adown1);
        double adown1 = Double.parseDouble(textadown1.getText().toString());

        //adown2
        TextView textadown2 = findViewById(R.id.E21adown2);
        double adown2 = Double.parseDouble(textadown2.getText().toString());

        //adown3
        TextView textadown3 = findViewById(R.id.E21adown3);
        double adown3 = Double.parseDouble(textadown3.getText().toString());

        //adown4
        TextView textadown4 = findViewById(R.id.E21adown4);
        double adown4 = Double.parseDouble(textadown4.getText().toString());

        //adown5
        TextView textadown5 = findViewById(R.id.E21adown5);
        double adown5 = Double.parseDouble(textadown5.getText().toString());

        //adown6
        TextView textadown6 = findViewById(R.id.E21adown6);
        double adown6 = Double.parseDouble(textadown6.getText().toString());

        //adown7
        TextView textadown7 = findViewById(R.id.E21adown7);
        double adown7 = Double.parseDouble(textadown7.getText().toString());

        //adown8
        TextView textadown8 = findViewById(R.id.E21adown8);
        double adown8 = Double.parseDouble(textadown8.getText().toString());

        //D1
        TextView textD1 = findViewById(R.id.E22D11);
        double D1 = Double.parseDouble(textD1.getText().toString());

        //D2
        TextView textD2 = findViewById(R.id.E22D12);
        double D2 = Double.parseDouble(textD2.getText().toString());

        //D3
        TextView textD3 = findViewById(R.id.E22D13);
        double D3 = Double.parseDouble(textD3.getText().toString());

        //D4
        TextView textD4 = findViewById(R.id.E22D14);
        double D4 = Double.parseDouble(textD4.getText().toString());

        //D5
        TextView textD5 = findViewById(R.id.E22D15);
        double D5 = Double.parseDouble(textD5.getText().toString());

        //D6
        TextView textD6 = findViewById(R.id.E22D16);
        double D6 = Double.parseDouble(textD6.getText().toString());

        //D7
        TextView textD7 = findViewById(R.id.E22D17);
        double D7 = Double.parseDouble(textD7.getText().toString());

        //D8
        TextView textD8 = findViewById(R.id.E22D18);
        double D8 = Double.parseDouble(textD8.getText().toString());

        //D9
        TextView textD9 = findViewById(R.id.E22D19);
        double D9 = Double.parseDouble(textD9.getText().toString());

        //D10
        TextView textD10 = findViewById(R.id.E22D110);
        double D10 = Double.parseDouble(textD10.getText().toString());

        //X1up1
        TextView textX1up1 = findViewById(R.id.E23X1up1);
        double X1up1 = Double.parseDouble(textX1up1.getText().toString());

        //X1up2
        TextView textX1up2 = findViewById(R.id.E23X1up2);
        double X1up2 = Double.parseDouble(textX1up2.getText().toString());

        //X1up3
        TextView textX1up3 = findViewById(R.id.E23X1up3);
        double X1up3 = Double.parseDouble(textX1up3.getText().toString());

        //X1up4
        TextView textX1up4 = findViewById(R.id.E23X1up4);
        double X1up4 = Double.parseDouble(textX1up4.getText().toString());

        //X1up5
        TextView textX1up5 = findViewById(R.id.E23X1up5);
        double X1up5 = Double.parseDouble(textX1up5.getText().toString());

        //X1down1
        TextView textX1down1 = findViewById(R.id.E23X1down1);
        double X1down1 = Double.parseDouble(textX1down1.getText().toString());

        //X1down2
        TextView textX1down2 = findViewById(R.id.E23X1down2);
        double X1down2 = Double.parseDouble(textX1down2.getText().toString());

        //X1down3
        TextView textX1down3 = findViewById(R.id.E23X1down3);
        double X1down3 = Double.parseDouble(textX1down3.getText().toString());

        //X1down4
        TextView textX1down4 = findViewById(R.id.E23X1down4);
        double X1down4 = Double.parseDouble(textX1down4.getText().toString());

        //X1down5
        TextView textX1down5 = findViewById(R.id.E23X1down5);
        double X1down5 = Double.parseDouble(textX1down5.getText().toString());

        //b1
        TextView textb1 = findViewById(R.id.E23b1);
        double b1 = Double.parseDouble(textb1.getText().toString());

        //b2
        TextView textb2 = findViewById(R.id.E23b2);
        double b2 = Double.parseDouble(textb2.getText().toString());

        //b3
        TextView textb3 = findViewById(R.id.E23b3);
        double b3 = Double.parseDouble(textb3.getText().toString());

        //b4
        TextView textb4 = findViewById(R.id.E23b4);
        double b4 = Double.parseDouble(textb4.getText().toString());

        //b5
        TextView textb5 = findViewById(R.id.E23b5);
        double b5 = Double.parseDouble(textb5.getText().toString());

        //L
        TextView textL = findViewById(R.id.E23L);
        double L = Double.parseDouble(textL.getText().toString());

        Double[] aup = new Double[]{aup1,aup2,aup3,aup4,aup5,aup6,aup7,aup8};
        Double[] adown = new Double[]{adown1,adown2,adown3,adown4,adown5,adown6,adown7,adown8};
        Double[] D = new Double[]{D1,D2,D3,D4,D5,D6,D7,D8,D9,D10};
        Double[] X1up = new Double[]{X1up1,X1up2,X1up3,X1up4,X1up5};
        Double[] X1down = new Double[]{X1down1,X1down2,X1down3,X1down4,X1down5};
        Double[] b = new Double[]{b1,b2,b3,b4,b5};

        OneActivity.database2.setAUp(aup);
        OneActivity.database2.setADown(adown);
        OneActivity.database2.setD(D);
        OneActivity.database2.setX1(X1up);
        OneActivity.database2.setX2(X1down);
        OneActivity.database2.setB(b);
        OneActivity.database2.setL(L);
        OneActivity.database2.dataProcess();
    }
}
