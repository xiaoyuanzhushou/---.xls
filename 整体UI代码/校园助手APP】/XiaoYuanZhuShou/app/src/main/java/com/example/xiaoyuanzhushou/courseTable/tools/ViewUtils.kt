package com.example.xiaoyuanzhushou.courseTable.tools


import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Point
import android.os.Build
import android.os.Environment
import android.text.Html
import android.text.Spanned
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.text.HtmlCompat
import com.example.xiaoyuanzhushou.R

import java.io.File
import java.io.FileOutputStream



object ViewUtils {
    fun getCustomizedColor(context: Context, index: Int): Int {
        val customizedColors = context.resources.getIntArray(R.array.customizedColors)
        return customizedColors[index]
    }

}