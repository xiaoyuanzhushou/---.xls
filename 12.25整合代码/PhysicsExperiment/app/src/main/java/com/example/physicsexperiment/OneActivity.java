package com.example.physicsexperiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class OneActivity extends AppCompatActivity {

    static Database1 database11 = new Database1();
    static Database1 database12 = new Database1();
    static Database2 database2 = new Database2();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initDatas1();
                initDatas12();
                startActivity(new Intent(OneActivity.this,
                        ResultOneActivity.class));
            }
        });

        /*Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initDatas2();
                startActivity(new Intent(OneActivity.this,
                        ResultTwoActivity.class));
            }
        });*/
        }

    public void initDatas1(){
            TextView textf = findViewById(R.id.E11f);
            int f = Integer.parseInt(textf.getText().toString());
            Integer F= new Integer(f);

            //获取室温t
            TextView textt = findViewById(R.id.E11t);
            int t = Integer.parseInt(textt.getText().toString());
            Integer T= new Integer(t);

            //获取数据1
            TextView text1 = findViewById(R.id.E11Xi1);
            int xi1 = Integer.parseInt(text1.getText().toString());
            Integer Xi1 = new Integer(xi1);

            //2
            TextView text2 = findViewById(R.id.E11Xi2);
            int xi2 = Integer.parseInt(text2.getText().toString());
            Integer Xi2 = new Integer(xi2);

            //3
            TextView text3 = findViewById(R.id.E11Xi3);
            int xi3 = Integer.parseInt(text3.getText().toString());
            Integer Xi3 = new Integer(xi3);

            //4
            TextView text4 = findViewById(R.id.E11Xi4);
            int xi4 = Integer.parseInt(text4.getText().toString());
            Integer Xi4 = new Integer(xi4);

            //5
            TextView text5 = findViewById(R.id.E11Xi5);
            int xi5 = Integer.parseInt(text5.getText().toString());
            Integer Xi5 = new Integer(xi5);

            //6
            TextView text6 = findViewById(R.id.E11Xi6);
            int xi6 = Integer.parseInt(text6.getText().toString());
            Integer Xi6 = new Integer(xi6);

            //7
            TextView text7 = findViewById(R.id.E11Xi7);
            int xi7 = Integer.parseInt(text7.getText().toString());
            Integer Xi7 = new Integer(xi7);

            //8
            TextView text8 = findViewById(R.id.E11Xi8);
            int xi8 = Integer.parseInt(text8.getText().toString());
            Integer Xi8 = new Integer(xi8);

            //9
            TextView text9 = findViewById(R.id.E11Xi9);
            int xi9 = Integer.parseInt(text9.getText().toString());
            Integer Xi9 = new Integer(xi9);

            //10
            TextView text10 = findViewById(R.id.E11Xi10);
            int xi10 = Integer.parseInt(text10.getText().toString());
            Integer Xi10 = new Integer(xi10);

            Integer[] a = new Integer[]{Xi1,Xi2,Xi3,Xi4,Xi5,Xi6,Xi7,Xi8,Xi9,Xi10};



            database11.setF(F);
            database11.setT(T);
            database11.setXi(Arrays.asList(a));
            database11.dataProcess();
        }

    public void initDatas12(){
        TextView textf = findViewById(R.id.E12f);
        int f = Integer.parseInt(textf.getText().toString());
        Integer F= new Integer(f);

        //获取室温t
        TextView textt = findViewById(R.id.E12t);
        int t = Integer.parseInt(textt.getText().toString());
        Integer T= new Integer(t);

        //获取数据1
        TextView text1 = findViewById(R.id.E12Xi1);
        int xi1 = Integer.parseInt(text1.getText().toString());
        Integer Xi1 = new Integer(xi1);

        //2
        TextView text2 = findViewById(R.id.E12Xi2);
        int xi2 = Integer.parseInt(text2.getText().toString());
        Integer Xi2 = new Integer(xi2);

        //3
        TextView text3 = findViewById(R.id.E12Xi3);
        int xi3 = Integer.parseInt(text3.getText().toString());
        Integer Xi3 = new Integer(xi3);

        //4
        TextView text4 = findViewById(R.id.E12Xi4);
        int xi4 = Integer.parseInt(text4.getText().toString());
        Integer Xi4 = new Integer(xi4);

        //5
        TextView text5 = findViewById(R.id.E12Xi5);
        int xi5 = Integer.parseInt(text5.getText().toString());
        Integer Xi5 = new Integer(xi5);

        //6
        TextView text6 = findViewById(R.id.E12Xi6);
        int xi6 = Integer.parseInt(text6.getText().toString());
        Integer Xi6 = new Integer(xi6);

        //7
        TextView text7 = findViewById(R.id.E12Xi7);
        int xi7 = Integer.parseInt(text7.getText().toString());
        Integer Xi7 = new Integer(xi7);

        //8
        TextView text8 = findViewById(R.id.E12Xi8);
        int xi8 = Integer.parseInt(text8.getText().toString());
        Integer Xi8 = new Integer(xi8);

        //9
        TextView text9 = findViewById(R.id.E12Xi9);
        int xi9 = Integer.parseInt(text9.getText().toString());
        Integer Xi9 = new Integer(xi9);

        //10
        TextView text10 = findViewById(R.id.E12Xi10);
        int xi10 = Integer.parseInt(text10.getText().toString());
        Integer Xi10 = new Integer(xi10);

        Integer[] a = new Integer[]{Xi1,Xi2,Xi3,Xi4,Xi5,Xi6,Xi7,Xi8,Xi9,Xi10};



        database12.setF(F);
        database12.setT(T);
        database12.setXi(Arrays.asList(a));
        database12.dataProcess();
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

        database2.setAUp(aup);
        database2.setADown(adown);
        database2.setD(D);
        database2.setX1(X1up);
        database2.setX2(X1down);
        database2.setB(b);
        database2.setL(L);
        database2.dataProcess();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}