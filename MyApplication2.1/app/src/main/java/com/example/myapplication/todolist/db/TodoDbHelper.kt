package com.example.myapplication.todolist.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.myapplication.todolist.db.TodoContract.SQL_CREATE_ENTRIES
import com.example.myapplication.todolist.db.TodoContract.SQL_DELETE_ENTRIES

//数据库帮助类
class TodoDbHelper(context: Context?) : SQLiteOpenHelper(context, "TodoList.db", null, 6){

    // TODO 定义数据库名、版本；创建数据库
    val DATABASE_VERSION = 6
    val DATA_NAME = "TodoList.db"


    override fun onCreate(db: SQLiteDatabase) {
        Log.d("data", SQL_CREATE_ENTRIES)
        db.execSQL(SQL_CREATE_ENTRIES)
//        Log.d("data", "onCreate execute");
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

}
