package com.example.myapplication.todolist.operation.db.Dao

import androidx.room.*
import com.example.myapplication.todolist.operation.db.entity.User


@Dao
interface UserDao {
    @get:Query("SELECT * FROM user")
    val all: List<Any?>?

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray?): List<User?>?

    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String?, last: String?): User?

    @Insert
    fun insertAll(vararg users: User?)

    @Update
    fun update(user: User?)

    @Delete
    fun delete(user: User?)
}