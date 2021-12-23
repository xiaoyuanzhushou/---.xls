package com.byted.camp.todolist;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.byted.camp.todolist.widget.RippleWrapper;
import com.byted.camp.todolist.widget.TickProgressBar;

public class TomatoActivity extends AppCompatActivity {



    // 场景
    public static final int SCENE_WORK = 0;
    public static final int SCENE_SHORT_BREAK = 1;
    public static final int SCENE_LONG_BREAK = 2;

    // 当前状态
    public static final int STATE_WAIT = 0;
    public static final int STATE_WORK = 1;
    public static final int STATE_PAUSE = 2;
    public static final int STATE_FINISH = 3;

    //时间初始值
    public static final long WORK_TIME = 1500000;
    public static final long SHORT_BREAK_TIME = 300000;
    public static final long LONG_BREAK_TIME = 1200000;

    private int mState;
    private int mScene;

    public static long mRemainingTime ;


    public static TextView tv = null;






    private Button mBtnStart;
    private Button mBtnPause;
    private Button mBtnResume;
    private ImageButton computer;
    private ImageButton cafe;
    private ImageButton couch;


    private MyCountDownTimer mc;
    private TickProgressBar mProgressBar;
    private RippleWrapper mRippleWrapper;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato);
        setTitle("番茄钟");
        mState = STATE_WAIT;
        mScene = SCENE_WORK;

        computer = findViewById(R.id.imageButton_computer);
        computer.setBackgroundColor(Color.TRANSPARENT);
        computer.setFocusable(true);

        cafe = findViewById(R.id.imageButton_cafe);
        cafe.setBackgroundColor(Color.TRANSPARENT);
        cafe.setFocusable(true);

        couch = findViewById(R.id.imageButton_couch);
        couch.setBackgroundColor(Color.TRANSPARENT);
        couch.setFocusable(true);

        mBtnStart = findViewById(R.id.btn_start);
        mBtnPause = findViewById(R.id.btn_pause);
        mBtnResume = findViewById(R.id.btn_resume);




        mProgressBar = findViewById(R.id.tick_progress_bar);
        mRippleWrapper = findViewById(R.id.ripple_wrapper);

        tv = findViewById(R.id.text_count_down);

        mc = new MyCountDownTimer(WORK_TIME+50,1000);





        initActions();



    }

    private void initActions() {
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmState(STATE_WORK);

                updateStateButtons();
                //updateRipple();
            }
        });

        mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmState(STATE_PAUSE);

                updateStateButtons();
            }
        });

        mBtnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmState(STATE_WORK);
                mc = new MyCountDownTimer(mRemainingTime+50,1000);
                updateStateButtons();
            }
        });

        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mc.cancel();

                mBtnStart.setVisibility(View.VISIBLE);
                mBtnPause.setVisibility(View.GONE);
                mBtnResume.setVisibility(View.GONE);

                setmScene(SCENE_WORK);
                updateSceneButtons();
            }
        });

        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mc.cancel();

                mBtnStart.setVisibility(View.VISIBLE);
                mBtnPause.setVisibility(View.GONE);
                mBtnResume.setVisibility(View.GONE);

                setmScene(SCENE_SHORT_BREAK);
                updateSceneButtons();
            }
        });

        couch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mc.cancel();

                mBtnStart.setVisibility(View.VISIBLE);
                mBtnPause.setVisibility(View.GONE);
                mBtnResume.setVisibility(View.GONE);

                setmScene(SCENE_LONG_BREAK);
                updateSceneButtons();

            }
        });

    }

    private void updateStateButtons() {
        int state = getmState();


        if(state == STATE_WORK){
            setmState(state);
            mBtnStart.setVisibility(View.GONE);
            mBtnPause.setVisibility(View.VISIBLE);
            mBtnResume.setVisibility(View.GONE);
            mc.start();

        }

        if(state == STATE_PAUSE){
            setmState(state);
            mBtnStart.setVisibility(View.GONE);
            mBtnPause.setVisibility(View.GONE);
            mBtnResume.setVisibility(View.VISIBLE);
            //调用CountDownTimer的暂停方法
            mc.pause();
        }

        if(state == STATE_FINISH){
            setmState(state);
            mBtnStart.setVisibility(View.VISIBLE);
            mBtnPause.setVisibility(View.GONE);
            mBtnResume.setVisibility(View.GONE);
            //从上一个状态继续倒计时
            mc.resume();
        }
    }

    private void updateSceneButtons(){
        int scene = getmScene();

        if(scene == SCENE_WORK){
            computer.setImageDrawable(getResources().getDrawable(R.drawable.ic_laptop_mac_white2_24dp));
            cafe.setImageDrawable(getResources().getDrawable(R.drawable.ic_local_cafe_white_24dp));
            couch.setImageDrawable(getResources().getDrawable(R.drawable.ic_weekend_white_24dp));

            tv.setText("25:00");
            //new对象，传入要停留的时间
            mc = new MyCountDownTimer(WORK_TIME+50,1000);
        }

        if(scene == SCENE_SHORT_BREAK){
            computer.setImageDrawable(getResources().getDrawable(R.drawable.ic_laptop_mac_white_24dp));
            cafe.setImageDrawable(getResources().getDrawable(R.drawable.ic_local_cafe2_white_24dp));
            couch.setImageDrawable(getResources().getDrawable(R.drawable.ic_weekend_white_24dp));

            tv.setText("5:00");
            //new对象，传入要停留的时间
            mc = new MyCountDownTimer(SHORT_BREAK_TIME+50,1000);
        }

        if(scene == SCENE_LONG_BREAK){
            computer.setImageDrawable(getResources().getDrawable(R.drawable.ic_laptop_mac_white_24dp));
            cafe.setImageDrawable(getResources().getDrawable(R.drawable.ic_local_cafe_white_24dp));
            couch.setImageDrawable(getResources().getDrawable(R.drawable.ic_weekend2_white_24dp));

            tv.setText("20:00");
            //new对象，传入要停留的时间
            mc = new MyCountDownTimer(LONG_BREAK_TIME+50,1000);
        }
    }

    public void onBackPressed() {


        if(getmScene()==SCENE_WORK && getmState()==STATE_WORK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Warning");
            builder.setMessage("正在工作中，返回后不会保存时间状态，确定要返回吗");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mc.cancel();
                    TomatoActivity.super.onBackPressed();
                }
            });

            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            });

            builder.show();
        } else {
            mc.cancel();
            super.onBackPressed();
        }
    }



    //状态的getter和setter方法
    public int getmState() {
        return mState;
    }

    public void setmState(int mState) {
        this.mState = mState;
    }

    public int getmScene() {
        return mScene;
    }

    public void setmScene(int mScene) {
        this.mScene = mScene;
    }


    class MyCountDownTimer extends CountDownTimer {

        private long mInterval = 0;


        /**
             *
             * @param startTime
             *      表示以毫秒为单位 初始或每一次暂停后继续的初始时间
             *
             *      StartTime=1000 表示1秒
             *
             * @param countDownInterval
             *      表示 间隔 多少微秒 调用一次 onTick 方法
             *
             *      例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
             *
             */
            public MyCountDownTimer(long startTime, long countDownInterval) {
                super(startTime, countDownInterval);
                this.mInterval = countDownInterval;
                TomatoActivity.mRemainingTime = startTime;

            }

        @Override
            public void onFinish() {
                tv.setText("已结束");
                mBtnStart.setVisibility(View.VISIBLE);
                mBtnPause.setVisibility(View.GONE);
                mBtnResume.setVisibility(View.GONE);
                updateSceneButtons();
                //computer.setImageDrawable(getResources().getDrawable(R.drawable.ic_laptop_mac_white_24dp));
                //cafe.setImageDrawable(getResources().getDrawable(R.drawable.ic_local_cafe_white_24dp));
                //couch.setImageDrawable(getResources().getDrawable(R.drawable.ic_weekend_white_24dp));
                mc.cancel();
            }

            @Override
            public void onTick(long millisUntilFinished) {
                String secondsPart;
                millisUntilFinished = millisUntilFinished + 3;
                Log.i("MainActivity", mRemainingTime  + "");
                mRemainingTime = millisUntilFinished;

                if( Math.round((double)mRemainingTime  / 1000) % 60 < 10) {
                    secondsPart = "0" + Math.round((double)mRemainingTime  / 1000) % 60 ;
                }else{
                    secondsPart = String.valueOf(Math.round( (double)mRemainingTime  / 1000) % 60 );
                }

                tv.setText(""+ mRemainingTime  / 1000 / 60 +":"+ secondsPart );

            }


        public void pause(){
            //暂停当前时间
            this.cancel();
        }

        public MyCountDownTimer resume(){
            /* 使用上次保存的数据创建一个计数器 */
            MyCountDownTimer newTimer = new MyCountDownTimer(mRemainingTime,mInterval);
            /* 启动这个新的计时器，从旧的地方开始 */
            newTimer.start();
            /* 返回计时器 */
            return newTimer;
        }
    }

}
