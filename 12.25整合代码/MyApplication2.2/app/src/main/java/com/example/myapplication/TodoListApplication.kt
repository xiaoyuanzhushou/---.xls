package com.example.myapplication

import android.annotation.SuppressLint
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

        lateinit var context: Context


    }


}
