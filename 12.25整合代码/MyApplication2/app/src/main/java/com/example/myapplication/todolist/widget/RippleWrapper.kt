package com.example.myapplication.todolist.widget

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import java.util.ArrayList

class RippleWrapper @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(context, attrs, defStyleAttr) {
    private var mIsRunning = false
    private var mAnimatorSet: AnimatorSet? = null
    private var mRippleColor = 0
    private var mRippleDuration = 0
    private var mRippleDelay = 0
    private var mRippleAmount = 0
    fun init(context: Context, attrs: AttributeSet?) {
        if (isInEditMode) {
            return
        }
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RippleWrapper)
        mRippleColor = typedArray.getColor(
            R.styleable.RippleWrapper_rippleColor,
            ContextCompat.getColor(context, R.color.colorRipple)
        )
        mRippleDuration = typedArray.getInteger(R.styleable.RippleWrapper_rippleDuration, 5000)
        mRippleDelay = typedArray.getInteger(R.styleable.RippleWrapper_rippleDelay, 2500)
        mRippleAmount = typedArray.getInteger(R.styleable.RippleWrapper_rippleAmount, 1)
        typedArray.recycle()
        isFocusable = false
    }

    fun build() {
        val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        params.addRule(CENTER_IN_PARENT, TRUE)
        mAnimatorSet = AnimatorSet()
        val animators = ArrayList<Animator>()
        for (i in 0 until mRippleAmount) {
            val rippleView: RippleView = RippleView(context, mRippleColor)
            addView(rippleView, params)
            val widthAnimator = ObjectAnimator.ofFloat(rippleView, SCALE_X, 1.0f, 1.318f)
            widthAnimator.repeatCount = ObjectAnimator.INFINITE
            widthAnimator.repeatMode = ObjectAnimator.RESTART
            widthAnimator.duration = mRippleDuration.toLong()
            widthAnimator.startDelay = (i * mRippleDelay).toLong()
            widthAnimator.interpolator = AccelerateInterpolator()
            animators.add(widthAnimator)
            val heightAnimator = ObjectAnimator.ofFloat(rippleView, SCALE_Y, 1.0f, 1.318f)
            heightAnimator.repeatCount = ObjectAnimator.INFINITE
            heightAnimator.repeatMode = ObjectAnimator.RESTART
            heightAnimator.duration = mRippleDuration.toLong()
            heightAnimator.startDelay = (i * mRippleDelay).toLong()
            heightAnimator.interpolator = AccelerateInterpolator()
            animators.add(heightAnimator)
            val alphaAnimator = ObjectAnimator.ofFloat(rippleView, ALPHA, 1.0f, 0f)
            alphaAnimator.repeatCount = ObjectAnimator.INFINITE
            alphaAnimator.repeatMode = ObjectAnimator.RESTART
            alphaAnimator.duration = mRippleDuration.toLong()
            alphaAnimator.startDelay = (i * mRippleDelay).toLong()
            alphaAnimator.interpolator = AccelerateInterpolator()
            animators.add(alphaAnimator)
        }
        mAnimatorSet!!.playTogether(animators)
        mAnimatorSet!!.start()
    }

    fun start() {
        if (!mIsRunning) {
            build()
            mIsRunning = true
        }
    }

    fun stop() {
        if (mIsRunning) {
            mAnimatorSet!!.end()
            mIsRunning = false
        }
    }

    private inner class RippleView(context: Context?, private val mColor: Int) :
        View(context) {
        private val mPaint: Paint
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val width = width
            val height = height
            val min = if (width > height) height else width
            val half = (min / 2).toFloat()
            val halfWidth = (width / 2).toFloat()
            val scale = 0.618f
            val rippleRadius = half * scale + 4.0f
            canvas.drawCircle(halfWidth, half, rippleRadius, mPaint)
        }

        private val drawPaint: Paint
            private get() {
                val paint = Paint()
                paint.isAntiAlias = true
                paint.color = mColor
                paint.strokeWidth = 3.0f
                paint.style = Paint.Style.STROKE
                return paint
            }

        init {
            mPaint = drawPaint
        }
    }

    init {
        init(context, attrs)
    }
}
