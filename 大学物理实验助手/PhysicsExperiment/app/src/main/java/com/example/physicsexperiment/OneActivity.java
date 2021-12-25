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

    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button button1 = findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    initDatas1();
                    initDatas12();
                    startActivity(new Intent(OneActivity.this, ResultOneActivity.class));
                }
            });

            /*Button button2 = findViewById(R.id.button2);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}