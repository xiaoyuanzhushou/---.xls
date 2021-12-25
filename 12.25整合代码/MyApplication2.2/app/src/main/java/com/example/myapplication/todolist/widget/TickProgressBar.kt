package com.example.myapplication.todolist.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import com.example.myapplication.R

class TickProgressBar @JvmOverloads constructor(
    context: Context,
    @Nullable attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    private var mColorArc = 0
    private var mColorCircle = 0
    private var mMaxProgress: Long = 0
    private var mProgress: Long = 0
    private var mPaintArc: Paint? = null
    private var mPaintCircle: Paint? = null
    private var mRectF: RectF? = null
    private fun init(context: Context) {
        mColorArc = ContextCompat.getColor(context, R.color.colorStrokeArc)
        mColorCircle = ContextCompat.getColor(context, R.color.colorStrokeCircle)
        isFocusable = false
        initPainters()
    }

    private fun initPainters() {
        mPaintCircle = paint
        mPaintCircle!!.color = mColorCircle
        mPaintArc = paint
        mPaintArc!!.color = mColorArc
        mRectF = RectF()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setRectF()
        canvas.drawArc(mRectF!!, -90.0f, 360.0f, false, mPaintCircle!!)
        canvas.drawArc(mRectF!!, -90.0f, sweepAngle, false, mPaintArc!!)
    }

    private val paint: Paint
        private get() {
            val paint = Paint()
            paint.isAntiAlias = true
            paint.strokeWidth = 6.0f
            paint.style = Paint.Style.STROKE
            return paint
        }

    private fun setRectF() {
        val width = width
        val height = height
        val size = if (width > height) height else width
        val radius = (size / 2).toFloat()
        val halfWidth = (width / 2).toFloat()
        val scale = 0.618f // 黄金分割
        val top = radius - radius * scale
        val left = halfWidth - radius * scale
        val right = halfWidth + radius * scale
        val bottom = radius + radius * scale
        mRectF!![left, top, right] = bottom
    }

    private val sweepAngle: Float
        private get() = 360.0f * (mProgress.toFloat() / mMaxProgress.toFloat())

    fun setMaxProgress(maxProgress: Long) {
        mMaxProgress = maxProgress
    }

    fun setProgress(progress: Long) {
        mProgress = mMaxProgress - progress
        invalidate()
    }

    init {
        init(context)
    }
}