package com.example.myapplication.todolist

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.todolist.beans.Note
import com.example.myapplication.todolist.beans.State
import com.example.myapplication.todolist.db.TodoContract
import com.example.myapplication.todolist.db.TodoDbHelper
import com.example.myapplication.todolist.operation.activity.SettingActivity
import com.example.myapplication.todolist.ui.NoteListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.todo_main.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class TodoList : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var notesAdapter: NoteListAdapter? = null
    private var dbHelper: TodoDbHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_main)
        val toolbar: Toolbar = findViewById(R.id.baseToolbar)

        //设置Toolbar中的标题颜色
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorTitle))

        //创建数据库
        dbHelper = TodoDbHelper(this)

        //悬浮加号按钮监听器
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener(View.OnClickListener { /* 使用@startActivityForResult，当noteActivity内容执行完后
                    调用@onActivityResult从数据库中返回加入的待办事项*/
            startActivityForResult(
                Intent(this@TodoList, NoteActivity::class.java),
                REQUEST_CODE_ADD
            )
        })


        //番茄图标监听器
        /*
        ImageButton Tom = findViewById(R.id.tomatoClock);
        Tom.setBackgroundColor(Color.TRANSPARENT);
        Tom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(MainActivity.this, TomatoActivity.class)
                );
            }
        });
    */
        //待办事项栏
        recyclerView = findViewById(R.id.list_todo)
        recyclerView!!.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        recyclerView!!.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )


        /* 接口NoteOperator作为函数形参,同时实现NoteOperator */notesAdapter =
            NoteListAdapter(object : NoteOperator {
                override fun deleteNote(note: Note?) {
                    val note1=note
                    if (note1 != null) {
                        this@TodoList.deleteNote(note1)
                    }
                }

                override fun updateNote(note: Note?) {
                    val note1=note
                    if (note1 != null) {
                        this@TodoList.updateNote(note1)
                    }
                }
            })
        recyclerView!!.adapter = notesAdapter
        try {
            notesAdapter!!.refresh(loadNotesFromDatabase())
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        /* 获取设置中的排序开关值 */
        val sp2: SharedPreferences = TodoListApplication.context!!
            .getSharedPreferences("sort", Context.MODE_MULTI_PROCESS)
        val isOpen = sp2.getBoolean("isopen", false)
        if (isOpen) {
            try {
                notesAdapter!!.refresh(loadNotesFromDatabase())
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
    }


    protected override fun onDestroy() {
        super.onDestroy()
    }

    //主页面菜单栏
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_main_todo, menu)
        return true
    }

    //主页面菜单栏选项监听器
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.action_settings -> {
                startActivityForResult(
                    Intent(this@TodoList, SettingActivity::class.java),
                    REQUEST_CODE_SORT
                )
                return true
            }
//            R.id.action_TomatoClock -> {
//                startActivity(Intent(this, TomatoActivity::class.java))
//                return true
//            }
            else -> {}
        }
        return super.onOptionsItemSelected(item)
    }

    protected override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD
            && resultCode == Activity.RESULT_OK
        ) {
            try {
                notesAdapter!!.refresh(loadNotesFromDatabase())
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        } else if (requestCode == REQUEST_CODE_SORT
            && resultCode == Activity.RESULT_CANCELED
        ) {
            try {
                notesAdapter!!.refresh(loadNotesFromDatabase())
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
    }

    /*
    private List<Note> sortNotesFromDatabase() throws ParseException {
        List<Note> list = loadNotesFromDatabase();
        SharedPreferences sp = this.getSharedPreferences("sort",
                Context.MODE_MULTI_PROCESS);
        boolean judge = sp.getBoolean("isopen", false);
        if (judge) {

            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = 0; j < list.size() - i - 1; j++) {
                    if (list.get(j).getPriority() >
                            list.get(j + 1).getPriority()) {
                        Note temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, list.get(j));

                    }
                }

            }

        }

        return list;
    }
*/
    @SuppressLint("Range")
    @Throws(ParseException::class)
    private fun loadNotesFromDatabase(): List<Note> {

        // TODO 从数据库中查询数据，并转换成 JavaBeans
        val list: MutableList<Note> = ArrayList<Note>()
        val db = dbHelper!!.writableDatabase
        val projection = arrayOf<String>(
            TodoContract.TodoEntry._ID,
            TodoContract.TodoEntry.COLUMN_CONTENT,
            TodoContract.TodoEntry.COLUMN_DATE,
            TodoContract.TodoEntry.COLUMN_STATE,
            TodoContract.TodoEntry.COLUMN_PRIORTY
        )
        val cursor =
            db.query(TodoContract.TodoEntry.TABLE_NAME, projection, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
//                Log.d("data", String.valueOf(cursor.getColumnIndex("_id")));
                val tempNote = Note(cursor.getLong(cursor.getColumnIndex("_id")))
                val content = cursor.getString(cursor.getColumnIndex("content"))
                //                Log.d("data", " In Main Load content is " + content);
                tempNote.content=content
                val date = cursor.getString(cursor.getColumnIndex("date"))
                //                Log.d("data", " In Main Load date is " + date);
                tempNote.date=SIMPLE_DATE_FORMAT.parse(date)
                val priority = cursor.getInt(cursor.getColumnIndex("priority"))
                //                Log.d("data", " In Main Load priority is " + priority);
                tempNote.priority=priority
                val state = cursor.getInt(cursor.getColumnIndex("state"))
                Log.d("data", " In Main Load state is " + State.from(state))
                tempNote.state= State.from(state)
                list.add(tempNote)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return list
    }

    private fun deleteNote(note: Note) {
        // TODO 删除数据
        val db = dbHelper!!.writableDatabase
        val selection: String = "_id" + " LIKE ? "
        val selectionArgs = arrayOf<String>(java.lang.String.valueOf(note.id))
        db.delete(TodoContract.TodoEntry.TABLE_NAME, selection, selectionArgs)
        try {
            notesAdapter!!.refresh(loadNotesFromDatabase())
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }

    private fun updateNote(note: Note) {

        // 更新数据
        val db = dbHelper!!.writableDatabase
        val values = ContentValues()
        val  state1=note.state
        if(state1!=null){
            Log.d("data", " In Main Load In updateNode state is " + State.refrom(state1))
            values.put(TodoContract.TodoEntry.COLUMN_STATE, State.refrom(state1))
        }


        val selection: String = "_id".toString() + " LIKE ? "
        val selectionArgs = arrayOf<String>(java.lang.String.valueOf(note.id))
        db.update(TodoContract.TodoEntry.TABLE_NAME, values, selection, selectionArgs)
    }

    companion object {
        //请求码设置任意，大于等于0即可
        private const val REQUEST_CODE_ADD = 1002
        private const val REQUEST_CODE_SORT = 1003
        private val SIMPLE_DATE_FORMAT =
            SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.ENGLISH)
    }
}
