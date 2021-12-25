package com.example.myapplication.todolist.beans

import java.util.*


class Note(val id: Long) {
    var date: Date? = null
    var state: State? = null
    var content: String? = null
    var priority = 0

}
