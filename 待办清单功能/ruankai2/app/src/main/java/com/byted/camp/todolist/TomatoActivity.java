package com.byted.camp.todolist;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.byted.camp.todolist.widget.RippleWrapper;
import com.byted.camp.todolist.widget.TickProgressBar;

public class TomatoActivity extends AppCompatActivity {
    public static final int DEFAULT_WORK_LENGTH = 25;
    public static final int DEFAULT_SHORT_BREAK = 5;
    public static final int DEFAULT_LONG_BREAK  = 20;
    public static final int DEFAULT_LONG_BREAK_FREQUENCY = 4; // 默认 4 次开始长休息

    // 场景
    public static final int SCENE_WORK = 0;
    public static final int SCENE_SHORT_BREAK = 1;
    public static final int SCENE_LONG_BREAK = 2;

    // 当前状态
    public static final int STATE_WAIT = 0;
    public static final int STATE_RUNNING = 1;
    public static final int STATE_PAUSE = 2;
    public static final int STATE_FINISH = 3;

    private long mStopTimeInFuture;
    private long mMillisInTotal;
    private long mMillisUntilFinished;

    private int mTimes;
    private int mState;







    private MenuItem mMenuItemIDLE;
    private Button mBtnStart;
    private Button mBtnPause;
    private Button mBtnResume;
    private Button mBtnStop;
    private Button mBtnSkip;
    private TextView tv;
    private MyCountDownTimer mc;
    private TickProgressBar mProgressBar;
    private RippleWrapper mRippleWrapper;
    private long mLastClickTime = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato);
        setTitle("番茄钟");
        mState = STATE_WAIT;

        ImageButton computer = findViewById(R.id.imageButton_computer);
        computer.setBackgroundColor(Color.TRANSPARENT);

        ImageButton cafe = findViewById(R.id.imageButton_cafe);
        cafe.setBackgroundColor(Color.TRANSPARENT);

        ImageButton couch = findViewById(R.id.imageButton_couch);
        couch.setBackgroundColor(Color.TRANSPARENT);

        mBtnStart = (Button)findViewById(R.id.btn_start);
        mBtnPause = (Button)findViewById(R.id.btn_pause);
        mBtnResume = (Button)findViewById(R.id.btn_resume);
        mBtnStop = (Button)findViewById(R.id.btn_stop);
        mBtnSkip = (Button)findViewById(R.id.btn_skip);

        //tv = (TextView)findViewById(R.id.text_time_title);
        mProgressBar = (TickProgressBar)findViewById(R.id.tick_progress_bar);
        mRippleWrapper = (RippleWrapper)findViewById(R.id.ripple_wrapper);

        tv = (TextView)findViewById(R.id.text_count_down);

        initActions();



    }

    private void initActions() {
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new对象，传入要停留的时间

                mc = new MyCountDownTimer(1500000,1000);
                //开始倒计时
                mc.start();
            }
        });

        mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

        class MyCountDownTimer extends CountDownTimer {
            /**
             *
             * @param millisInFuture
             *      表示以毫秒为单位 倒计时的总数
             *
             *      例如 millisInFuture=1000 表示1秒
             *
             * @param countDownInterval
             *      表示 间隔 多少微秒 调用一次 onTick 方法
             *
             *      例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
             *
             */
            public MyCountDownTimer(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override
            public void onFinish() {
                tv.setText("done");
            }

            @Override
            public void onTick(long millisUntilFinished) {
                String secondsPart;
                Log.i("MainActivity", millisUntilFinished + "");
                if(millisUntilFinished / 1000 % 60 < 10) {
                    secondsPart = "0" + millisUntilFinished / 1000 % 60 ;
                }else{
                    secondsPart = String.valueOf(millisUntilFinished / 1000 % 60 );
                }
                tv.setText(""+millisUntilFinished / 1000 / 60 +":"+ secondsPart );
            }
        }

}
