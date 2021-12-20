package com.example.xiaoyuanzhushou.courseTable.message

import androidx.room.Entity

@Entity(primaryKeys = ["id"])
data class AppWidgetBean(
    var id: Int,
    var baseType: Int,
    var detailType: Int,
    var info: String
)