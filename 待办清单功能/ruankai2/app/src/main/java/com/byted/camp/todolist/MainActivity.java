package com.byted.camp.todolist;

import static com.byted.camp.todolist.R.color.*;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.byted.camp.todolist.beans.Note;
import com.byted.camp.todolist.beans.State;
import com.byted.camp.todolist.db.TodoContract;
import com.byted.camp.todolist.db.TodoDbHelper;
import com.byted.camp.todolist.operation.activity.DatabaseActivity;
import com.byted.camp.todolist.operation.activity.DebugActivity;
import com.byted.camp.todolist.operation.activity.SettingActivity;
import com.byted.camp.todolist.ui.NoteListAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    //请求码设置任意，大于等于0即可
    private static final int REQUEST_CODE_ADD = 1002;
    private static final int REQUEST_CODE_SORT = 1003;
    private RecyclerView recyclerView;
    private NoteListAdapter notesAdapter;
    private TodoDbHelper dbHelper;

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT =
            new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.ENGLISH);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.baseToolbar);
        setSupportActionBar(toolbar);
        //设置Toolbar中的标题颜色
        toolbar.setTitleTextColor(getResources().getColor(colorTitle));

        //创建数据库
        dbHelper = new TodoDbHelper(this);

        //悬浮加号按钮监听器
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* 使用@startActivityForResult，当noteActivity内容执行完后
                调用@onActivityResult从数据库中返回加入的待办事项*/
                startActivityForResult(
                        new Intent(MainActivity.this, NoteActivity.class),
                        REQUEST_CODE_ADD);
            }
        });

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
        recyclerView = findViewById(R.id.list_todo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));




        // 接口NoteOperator作为函数形参
        notesAdapter = new NoteListAdapter(new NoteOperator() {
            @Override
            public void deleteNote(Note note) {
                MainActivity.this.deleteNote(note);
            }

            @Override
            public void updateNote(Note note) {
                MainActivity.this.updateNote(note);
            }
        });
        recyclerView.setAdapter(notesAdapter);

        try {
            notesAdapter.refresh(loadNotesFromDatabase());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SharedPreferences sp2 = TodoListApplication.getContext().getSharedPreferences("sort",Context.MODE_MULTI_PROCESS);
        boolean isOpen = sp2.getBoolean("isopen",false);
        if(isOpen){
            try {
                notesAdapter.refresh(loadNotesFromDatabase());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //主页面菜单栏
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //主页面菜单栏选项监听器
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                startActivityForResult(new Intent(MainActivity.this, SettingActivity.class),
                        REQUEST_CODE_SORT);
                return true;
            case R.id.action_TomatoClock:
                startActivity(new Intent(this,TomatoActivity.class));
                return true;
                //case R.id.action_debug:
            //    startActivity(new Intent(this, DebugActivity.class));
            //    return true;
            //case R.id.action_database:
            //    startActivity(new Intent(this, DatabaseActivity.class));
            //    return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD
                && resultCode == Activity.RESULT_OK) {

            try {
                notesAdapter.refresh(loadNotesFromDatabase());
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }else if(requestCode == REQUEST_CODE_SORT
                && resultCode == Activity.RESULT_CANCELED){

            try {
                notesAdapter.refresh(loadNotesFromDatabase());
            } catch (ParseException e) {
                e.printStackTrace();
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



    private List<Note> loadNotesFromDatabase() throws ParseException {

        // TODO 从数据库中查询数据，并转换成 JavaBeans
        List<Note> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] projection = {
                TodoContract.TodoEntry._ID,
                TodoContract.TodoEntry.COLUMN_CONTENT,
                TodoContract.TodoEntry.COLUMN_DATE,
                TodoContract.TodoEntry.COLUMN_STATE,
                TodoContract.TodoEntry.COLUMN_PRIORTY
        };
        Cursor cursor = db.query(TodoContract.TodoEntry.TABLE_NAME,projection,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do {
//                Log.d("data", String.valueOf(cursor.getColumnIndex("_id")));
                Note tempNote = new Note(cursor.getLong(cursor.getColumnIndex("_id")));
                String content = cursor.getString(cursor.getColumnIndex("content"));
//                Log.d("data", " In Main Load content is " + content);
                tempNote.setContent(content);

                String date = cursor.getString(cursor.getColumnIndex("date"));
//                Log.d("data", " In Main Load date is " + date);
                tempNote.setDate(SIMPLE_DATE_FORMAT.parse(date));

                Integer priority = cursor.getInt(cursor.getColumnIndex("priority"));
//                Log.d("data", " In Main Load priority is " + priority);
                tempNote.setPriority(priority);

                int state = cursor.getInt(cursor.getColumnIndex("state"));
                Log.d("data", " In Main Load state is " + State.from(state));
                tempNote.setState(State.from(state));

                list.add(tempNote);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    private void deleteNote(Note note) {
        // TODO 删除数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection = TodoContract.TodoEntry._ID +" LIKE ? ";
        String[] selectionArgs = {String.valueOf(note.getId())};
        db.delete(TodoContract.TodoEntry.TABLE_NAME,selection,selectionArgs);
        try {
            notesAdapter.refresh(loadNotesFromDatabase());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void updateNote(Note note) {
        // 更新数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        Log.d("data", " In Main Load In updateNode state is " + State.refrom(note.getState()));
        values.put(TodoContract.TodoEntry.COLUMN_STATE, State.refrom(note.getState()));
        String selection = TodoContract.TodoEntry._ID+" LIKE ? ";
        String[] selectionArgs = {String.valueOf(note.getId())};
        db.update(TodoContract.TodoEntry.TABLE_NAME, values, selection, selectionArgs);
    }

}
