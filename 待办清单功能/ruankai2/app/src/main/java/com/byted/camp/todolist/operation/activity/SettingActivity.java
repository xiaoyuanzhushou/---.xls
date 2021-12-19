package com.byted.camp.todolist.operation.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.byted.camp.todolist.R;
import com.byted.camp.todolist.TodoListApplication;

public class SettingActivity extends AppCompatActivity {

    private static final String KEY_IS_NEED_SORT = "is_need_sort";

    private Switch commentSwitch;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Context context = this;

        //todo 从sp读出数据更新isOpen字段

        //指定该SharedPreferences数据只能被本应用程序读
       SharedPreferences sp = TodoListApplication.getContext().getSharedPreferences("sort",Context.MODE_MULTI_PROCESS);

        commentSwitch = findViewById(R.id.switch_comment);
        commentSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //todo 存储开关值进sp
                if (!buttonView.isPressed()) {
                    return;
                }
                boolean isOpen = sp.getBoolean("isopen",false);
                Log.d("data","In SettingActivity  In Write isOpen:"+!isOpen);

                //修改sp中的键值对信息
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("isopen",!isOpen);
                editor.commit();
                Log.d("data", "isOpen found:"+sp.getBoolean("isopen",false));

                if(sp.getBoolean("isopen",false)){
                    isOpen = sp.getBoolean("isopen",false);
                    Toast.makeText(SettingActivity.this,
                            "已排序",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SettingActivity.this,
                            "取消排序",
                            Toast.LENGTH_SHORT).show();
                }
                finish();
            }


        });

        commentSwitch.setChecked(sp.getBoolean("isopen",false));

    }

}
