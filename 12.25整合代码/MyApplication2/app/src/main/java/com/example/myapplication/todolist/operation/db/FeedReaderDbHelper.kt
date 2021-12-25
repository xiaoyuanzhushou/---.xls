package com.example.myapplication.todolist.operation.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myapplication.todolist.operation.db.FeedReaderContract.SQL_CREATE_ENTRIES

class FeedReaderDbHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        /*
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL("");
        }

         */
    }

    companion object {
        // 如果要修改模式需要升级数据库
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "FeedReader.db"
    }
}