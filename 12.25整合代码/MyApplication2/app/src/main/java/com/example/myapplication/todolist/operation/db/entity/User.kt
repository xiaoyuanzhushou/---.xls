package com.example.myapplication.todolist.operation.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
class User {
    @PrimaryKey
    var uid = 0

    @ColumnInfo(name = "first_name")
    var firstName: String? = null

    @ColumnInfo(name = "last_name")
    var lastName: String? = null //
    //    @ColumnInfo(name = "age")
    //    public String age;
}
