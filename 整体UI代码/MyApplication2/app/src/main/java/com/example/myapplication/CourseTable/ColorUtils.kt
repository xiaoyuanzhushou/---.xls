package com.example.myapplication.CourseTable

import android.graphics.Color

object ColorUtils {
    fun getCourseBgColor(colorflag :Int):Int{
        when(colorflag){
            0-> return Color.parseColor("#95e987")
            1-> return Color.parseColor("#ffb67e")
            2-> return Color.parseColor("#8cc7fe")
            3-> return Color.parseColor("#7ba3eb")
            4-> return Color.parseColor("#e3ade8")
            5-> return Color.parseColor("#f9728b")
            6-> return Color.parseColor("#85e9cd")
            7-> return Color.parseColor("#f5a8cf")
            8-> return Color.parseColor("#a9e2a0")
            9-> return Color.parseColor("#70cec7");
            else->return Color.GRAY


        }

    }

}