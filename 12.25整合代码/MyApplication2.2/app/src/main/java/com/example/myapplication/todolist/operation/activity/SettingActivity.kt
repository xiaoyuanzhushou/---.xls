package com.example.myapplication.todolist.operation.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.TodoListApplication

class SettingActivity : AppCompatActivity() {
    private var commentSwitch: Switch? = null
    private var sp: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_todo)
        val context: Context = this

        //todo 从sp读出数据更新isOpen字段

        //指定该SharedPreferences数据只能被本应用程序读
        sp = TodoListApplication.context!!.getSharedPreferences("sort", MODE_MULTI_PROCESS)
        commentSwitch = findViewById(R.id.switch_comment)
        commentSwitch!!.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked -> //todo 存储开关值进sp
            if (!buttonView.isPressed) {
                return@OnCheckedChangeListener
            }
            var isOpen = sp!!.getBoolean("isopen", false)
            Log.d("data", "In SettingActivity  In Write isOpen:" + !isOpen)

            //修改sp中的键值对信息
            val editor = sp!!.edit()
            editor.putBoolean("isopen", !isOpen)
            editor.commit()
            Log.d("data", "isOpen found:" + sp!!.getBoolean("isopen", false))
            if (sp!!.getBoolean("isopen", false)) {
                isOpen = sp!!.getBoolean("isopen", false)
                Toast.makeText(
                    this@SettingActivity,
                    "已排序",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@SettingActivity,
                    "取消排序",
                    Toast.LENGTH_SHORT
                ).show()
            }
            finish()
        })
        commentSwitch!!.setChecked(sp!!.getBoolean("isopen", false))
    }

    companion object {
        private const val KEY_IS_NEED_SORT = "is_need_sort"
    }
}