/*
 * Copyright 2019 Louis Cognault Ayeva Derman. Use of this source code is governed by the Apache 2.0 license.
 */

@file:Suppress("NOTHING_TO_INLINE")

package splitties.resources

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build.VERSION.SDK_INT
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment

/**
 * @see [androidx.core.content.ContextCompat.getColor]
 */
@ColorInt
fun Context.color(@ColorRes colorRes: Int): Int = if (SDK_INT >= 23) getColor(colorRes) else {
    @Suppress("DEPRECATION")
    resources.getColor(colorRes)
}

inline fun Fragment.color(@ColorRes colorRes: Int) = context!!.color(colorRes)
inline fun View.color(@ColorRes colorRes: Int) = context.color(colorRes)

/**
 * @see [androidx.core.content.ContextCompat.getColorStateList]
 */
fun Context.colorSL(@ColorRes colorRes: Int): ColorStateList {
    return (if (SDK_INT >= 23) getColorStateList(colorRes) else {
        @Suppress("DEPRECATION")
        resources.getColorStateList(colorRes)
    })
}

inline fun Fragment.colorSL(@ColorRes colorRes: Int) = context!!.colorSL(colorRes)
inline fun View.colorSL(@ColorRes colorRes: Int) = context.colorSL(colorRes)

// Styled resources below

private inline val defaultColor get() = Color.RED

@ColorInt
fun Context.styledColor(
        @AttrRes attr: Int
): Int = withStyledAttributes(attr) { getColor(it, defaultColor) }

inline fun Fragment.styledColor(@AttrRes attr: Int) = context!!.styledColor(attr)
inline fun View.styledColor(@AttrRes attr: Int) = context.styledColor(attr)

fun Context.styledColorSL(
        @AttrRes attr: Int
): ColorStateList? = withStyledAttributes(attr) { getColorStateList(it) }

inline fun Fragment.styledColorSL(@AttrRes attr: Int) = context!!.styledColorSL(attr)
inline fun View.styledColorSL(@AttrRes attr: Int) = context.styledColorSL(attr)
