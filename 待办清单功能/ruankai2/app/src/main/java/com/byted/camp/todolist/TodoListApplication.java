package com.byted.camp.todolist;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;


public class TodoListApplication extends Application {
    private static Context context;



    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
