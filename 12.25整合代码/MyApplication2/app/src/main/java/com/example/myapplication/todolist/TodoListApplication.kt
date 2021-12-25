package com.example.myapplication.todolist

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho


class TodoListApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        context = applicationContext
    }

    companion object {
        var context: Context? = null
            private set
    }
}
