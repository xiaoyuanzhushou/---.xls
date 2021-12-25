package com.example.myapplication.todolist.db

import android.provider.BaseColumns


object TodoContract {
    // TODO 定义表结构和 SQL 语句常量
    const val SQL_CREATE_ENTRIES = ("CREATE TABLE " + TodoEntry.TABLE_NAME
            + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY autoincrement,"
            + TodoEntry.COLUMN_CONTENT + " TEXT,"
            + TodoEntry.COLUMN_DATE + " TEXT,"
            + TodoEntry.COLUMN_STATE + " TEXT,"
            + TodoEntry.COLUMN_PRIORTY + " INTEGER )")
    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TodoEntry.TABLE_NAME

    //该接口定义了_COUNT与_ID两个字符串常量
    object TodoEntry : BaseColumns {
        const val TABLE_NAME = "todo"
        const val COLUMN_CONTENT = "content"
        const val COLUMN_PRIORTY = "priority" //3-1优先级由低到高
        const val COLUMN_DATE = "date"
        const val COLUMN_STATE = "state" //1为已完成，0为未完成
        const val _ID="_id"
    }
}
