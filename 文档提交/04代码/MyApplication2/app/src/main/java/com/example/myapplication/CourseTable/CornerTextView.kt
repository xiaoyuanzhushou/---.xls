package com.example.myapplication.CourseTable

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.widget.TextView

class CornerTextView(context:Context,val mbgColor:Int,val mCornerSize:Int):androidx.appcompat.widget.AppCompatTextView(context) {

    public override fun onDraw(canvas: Canvas){
        val paint =Paint()
        paint.isAntiAlias=true
        paint.setColor(mbgColor)
        paint.alpha=180
        paint.style=Paint.Style.FILL
        canvas.drawRoundRect(RectF(0.0F, 0.0F, measuredWidth.toFloat(), measuredHeight.toFloat()), mCornerSize.toFloat(),
            mCornerSize.toFloat(),paint)
        super.onDraw(canvas)



    }




}