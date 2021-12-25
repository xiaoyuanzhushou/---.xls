package com.example.myapplication.todolist

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.todolist.widget.RippleWrapper
import com.example.myapplication.todolist.widget.TickProgressBar
import androidx.appcompat.app.AlertDialog

class TomatoActivity : AppCompatActivity() {
    private var mState = 0
    private var mScene = 0
    private var mBtnStart: Button? = null
    private var mBtnPause: Button? = null
    private var mBtnResume: Button? = null
    private var computer: ImageButton? = null
    private var cafe: ImageButton? = null
    private var couch: ImageButton? = null
    private var mc: MyCountDownTimer? = null
    private var mProgressBar: TickProgressBar? = null
    private var mRippleWrapper: RippleWrapper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tomato_todo)
        setTitle("番茄钟")
        mState = STATE_WAIT
        mScene = SCENE_WORK
        computer = findViewById(R.id.imageButton_computer)
        computer!!.setBackgroundColor(Color.TRANSPARENT)
        computer!!.isFocusable = true
        cafe = findViewById(R.id.imageButton_cafe)
        cafe!!.setBackgroundColor(Color.TRANSPARENT)
        cafe!!.isFocusable = true
        couch = findViewById(R.id.imageButton_couch)
        couch!!.setBackgroundColor(Color.TRANSPARENT)
        couch!!.isFocusable = true
        mBtnStart = findViewById(R.id.btn_start)
        mBtnPause = findViewById(R.id.btn_pause)
        mBtnResume = findViewById(R.id.btn_resume)
        mProgressBar = findViewById(R.id.tick_progress_bar)
        mRippleWrapper = findViewById(R.id.ripple_wrapper)
        tv = findViewById(R.id.text_count_down)
        mc = MyCountDownTimer(WORK_TIME + 50, 1000)
        initActions()
    }

    private fun initActions() {
        mBtnStart!!.setOnClickListener {
            setmState(STATE_WORK)
            updateStateButtons()
            //updateRipple();
        }
        mBtnPause!!.setOnClickListener {
            setmState(STATE_PAUSE)
            updateStateButtons()
        }
        mBtnResume!!.setOnClickListener {
            setmState(STATE_WORK)
            mc = MyCountDownTimer(mRemainingTime + 50, 1000)
            updateStateButtons()
        }
        computer!!.setOnClickListener {
            mc!!.cancel()
            mBtnStart!!.visibility = View.VISIBLE
            mBtnPause!!.visibility = View.GONE
            mBtnResume!!.visibility = View.GONE
            setmScene(SCENE_WORK)
            updateSceneButtons()
        }
        cafe!!.setOnClickListener {
            mc!!.cancel()
            mBtnStart!!.visibility = View.VISIBLE
            mBtnPause!!.visibility = View.GONE
            mBtnResume!!.visibility = View.GONE
            setmScene(SCENE_SHORT_BREAK)
            updateSceneButtons()
        }
        couch!!.setOnClickListener {
            mc!!.cancel()
            mBtnStart!!.visibility = View.VISIBLE
            mBtnPause!!.visibility = View.GONE
            mBtnResume!!.visibility = View.GONE
            setmScene(SCENE_LONG_BREAK)
            updateSceneButtons()
        }
    }

    private fun updateStateButtons() {
        val state = getmState()
        if (state == STATE_WORK) {
            setmState(state)
            mBtnStart!!.visibility = View.GONE
            mBtnPause!!.visibility = View.VISIBLE
            mBtnResume!!.visibility = View.GONE
            mc!!.start()
        }
        if (state == STATE_PAUSE) {
            setmState(state)
            mBtnStart!!.visibility = View.GONE
            mBtnPause!!.visibility = View.GONE
            mBtnResume!!.visibility = View.VISIBLE
            //调用CountDownTimer的暂停方法
            mc!!.pause()
        }
        if (state == STATE_FINISH) {
            setmState(state)
            mBtnStart!!.visibility = View.VISIBLE
            mBtnPause!!.visibility = View.GONE
            mBtnResume!!.visibility = View.GONE
            //从上一个状态继续倒计时
            mc!!.resume()
        }
    }

    private fun updateSceneButtons() {
        val scene = getmScene()
        if (scene == SCENE_WORK) {
            computer!!.setImageDrawable(getResources().getDrawable(R.drawable.ic_laptop_mac_white2_24dp))
            cafe!!.setImageDrawable(getResources().getDrawable(R.drawable.ic_local_cafe_white_24dp))
            couch!!.setImageDrawable(getResources().getDrawable(R.drawable.ic_weekend_white_24dp))
            tv!!.text = "25:00"
            //new对象，传入要停留的时间
            mc = MyCountDownTimer(WORK_TIME + 50, 1000)
        }
        if (scene == SCENE_SHORT_BREAK) {
            computer!!.setImageDrawable(getResources().getDrawable(R.drawable.ic_laptop_mac_white_24dp))
            cafe!!.setImageDrawable(getResources().getDrawable(R.drawable.ic_local_cafe2_white_24dp))
            couch!!.setImageDrawable(getResources().getDrawable(R.drawable.ic_weekend_white_24dp))
            tv!!.text = "5:00"
            //new对象，传入要停留的时间
            mc = MyCountDownTimer(SHORT_BREAK_TIME + 50, 1000)
        }
        if (scene == SCENE_LONG_BREAK) {
            computer!!.setImageDrawable(getResources().getDrawable(R.drawable.ic_laptop_mac_white_24dp))
            cafe!!.setImageDrawable(getResources().getDrawable(R.drawable.ic_local_cafe_white_24dp))
            couch!!.setImageDrawable(getResources().getDrawable(R.drawable.ic_weekend2_white_24dp))
            tv!!.text = "20:00"
            //new对象，传入要停留的时间
            mc = MyCountDownTimer(LONG_BREAK_TIME + 50, 1000)
        }
    }

    override fun onBackPressed() {
        if (getmScene() == SCENE_WORK && getmState() == STATE_WORK) {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("Warning")
            builder.setMessage("正在工作中，返回后不会保存时间状态，确定要返回吗")
            builder.setPositiveButton("确定",
                DialogInterface.OnClickListener { dialog, which ->
                    mc!!.cancel()
                    super@TomatoActivity.onBackPressed()
                })
            builder.setNegativeButton("取消",
                DialogInterface.OnClickListener { dialog, which -> return@OnClickListener })
            builder.show()
        } else {
            mc!!.cancel()
            super.onBackPressed()
        }
    }

    //状态的getter和setter方法
    fun getmState(): Int {
        return mState
    }

    fun setmState(mState: Int) {
        this.mState = mState
    }

    fun getmScene(): Int {
        return mScene
    }

    fun setmScene(mScene: Int) {
        this.mScene = mScene
    }

    internal inner class MyCountDownTimer(startTime: Long, countDownInterval: Long) :
        CountDownTimer(startTime, countDownInterval) {
        private var mInterval: Long = 0
        override fun onFinish() {
            tv!!.text = "已结束"
            mBtnStart!!.visibility = View.VISIBLE
            mBtnPause!!.visibility = View.GONE
            mBtnResume!!.visibility = View.GONE
            updateSceneButtons()
            //computer.setImageDrawable(getResources().getDrawable(R.drawable.ic_laptop_mac_white_24dp));
            //cafe.setImageDrawable(getResources().getDrawable(R.drawable.ic_local_cafe_white_24dp));
            //couch.setImageDrawable(getResources().getDrawable(R.drawable.ic_weekend_white_24dp));
            mc!!.cancel()
        }

        override fun onTick(millisUntilFinished: Long) {
            var millisUntilFinished = millisUntilFinished
            val secondsPart: String
            millisUntilFinished = millisUntilFinished + 3
            Log.i("MainActivity", mRemainingTime.toString() + "")
            mRemainingTime = millisUntilFinished
            secondsPart = if (Math.round(mRemainingTime.toDouble() / 1000) % 60 < 10) {
                "0" + Math.round(mRemainingTime.toDouble() / 1000) % 60
            } else {
                (Math.round(mRemainingTime.toDouble() / 1000) % 60).toString()
            }
            tv!!.text = "" + mRemainingTime / 1000 / 60 + ":" + secondsPart
        }

        fun pause() {
            //暂停当前时间
            cancel()
        }

        fun resume(): MyCountDownTimer {
            /* 使用上次保存的数据创建一个计数器 */
            val newTimer: MyCountDownTimer = MyCountDownTimer(mRemainingTime, mInterval)
            /* 启动这个新的计时器，从旧的地方开始 */newTimer.start()
            /* 返回计时器 */return newTimer
        }

        /**
         *
         * @param startTime
         * 表示以毫秒为单位 初始或每一次暂停后继续的初始时间
         *
         * StartTime=1000 表示1秒
         *
         * @param countDownInterval
         * 表示 间隔 多少微秒 调用一次 onTick 方法
         *
         * 例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
         */
        init {
            mInterval = countDownInterval
            mRemainingTime = startTime
        }
    }

    companion object {
        // 场景
        const val SCENE_WORK = 0
        const val SCENE_SHORT_BREAK = 1
        const val SCENE_LONG_BREAK = 2

        // 当前状态
        const val STATE_WAIT = 0
        const val STATE_WORK = 1
        const val STATE_PAUSE = 2
        const val STATE_FINISH = 3

        //时间初始值
        const val WORK_TIME: Long = 1500000
        const val SHORT_BREAK_TIME: Long = 300000
        const val LONG_BREAK_TIME: Long = 1200000
        var mRemainingTime: Long = 0
        var tv: TextView? = null
    }
}
