/*
package com.byted.camp.todolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toolbar;

public class BaseActivity extends AppCompatActivity {
    //通用的Toolbar标题
    private TextView BaseTitle;
    //通用的ToolBar
    private Toolbar BaseToolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(findViewById(R.id.toolbar));
        initView();
        setSupportActionBar(BaseToolbar);
    }

    private void initView(){
        BaseTitle = findViewById(R.id.toolBarTitle);
        BaseToolbar = findViewById(R.id.toolbar);

    }

}
*/