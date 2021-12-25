package com.example.scoredata

import android.os.Parcelable
import java.io.Serializable

data class DegreeData(

    var course: String = "",    // 课程名称

    var final_result: String = "",       // 最终成绩

    var grade_point: String = "",      //绩点

): Serializable