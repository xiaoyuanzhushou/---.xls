package com.example.myapplication.todolist.operation.activity

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.*
import android.provider.BaseColumns
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.todolist.operation.db.FeedReaderContract
import com.example.myapplication.todolist.operation.db.FeedReaderDbHelper


class DatabaseActivity : AppCompatActivity(), View.OnClickListener {
    private var addBtn: Button? = null
    private var deleteBtn: Button? = null
    private var updateBtn: Button? = null
    private var queryBtn: Button? = null
    private var mWorkThread: HandlerThread? = null
    private var mWorkHander: WorkHander? = null
    private var dbHelper: FeedReaderDbHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
        addBtn = findViewById(R.id.btn_add)
        addBtn!!.setOnClickListener(this)
        deleteBtn = findViewById(R.id.btn_delete)
        deleteBtn!!.setOnClickListener(this)
        updateBtn = findViewById(R.id.btn_update)
        updateBtn!!.setOnClickListener(this)
        queryBtn = findViewById(R.id.btn_query)
        queryBtn!!.setOnClickListener(this)
        mWorkThread = HandlerThread("operation_database")
        mWorkThread!!.start()
        mWorkHander = WorkHander(mWorkThread!!.looper)
        dbHelper = FeedReaderDbHelper(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mWorkThread!!.quitSafely()
        dbHelper!!.close()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.btn_add) {
            mWorkHander!!.sendEmptyMessage(Databasemodel.MSG_ADD_DATA)
        } else if (id == R.id.btn_delete) {
            mWorkHander!!.sendEmptyMessage(Databasemodel.MSG_DELETE_DATA)
        } else if (id == R.id.btn_update) {
            mWorkHander!!.sendEmptyMessage(Databasemodel.MSG_UPDATE_DATA)
        } else if (id == R.id.btn_query) {
            mWorkHander!!.sendEmptyMessage(Databasemodel.MSG_QUERY_DATA)
        }
    }

    private fun addData() {
        // Gets the data repository in write mode
        val db: SQLiteDatabase = dbHelper!!.getWritableDatabase()

        // Create a new map of values, where column names are the keys
        val values = ContentValues()
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "my_title")
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "my_subtitle")

        // Insert the new row, returning the primary key value of the new row
        var newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values)
        Log.i(TAG, "perform add data, result:$newRowId")
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "title1")
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "my_subtitle1")
        newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values)
        Log.i(
            TAG,
            "perform add data(title1), result:$newRowId"
        )
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "title2")
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "my_subtitle2")
        newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values)
        Log.i(
            TAG,
            "perform add data(title2), result:$newRowId"
        )
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "title3")
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "my_subtitle3")
        newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values)
        Log.i(
            TAG,
            "perform add data(title3), result:$newRowId"
        )

//        User user = new User();
//        user.firstName = "zhang";
//        user.lastName = "san";
//        AppDatabase.getInstance(this).userDao().insertAll(user);
    }

    private fun deleteData() {
        // Gets the data repository in write mode
        val db: SQLiteDatabase = dbHelper!!.getWritableDatabase()

        // Define 'where' part of query.
        val selection: String = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE.toString() + " LIKE ?"
        // Specify arguments in placeholder order.
        val selectionArgs = arrayOf("my_title")
        // Issue SQL statement.
        val deletedRows = db.delete(FeedReaderContract.FeedEntry.TABLE_NAME, selection, selectionArgs)
        Log.i(
            TAG,
            "perform delete data, result:$deletedRows"
        )
    }

    private fun updateData() {
        val db: SQLiteDatabase = dbHelper!!.getWritableDatabase()

        // New value for one column
        val title = "title_1"
        val values = ContentValues()
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, title)

        // Which row to update, based on the title
        val selection: String = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE.toString() + " LIKE ?"
        val selectionArgs = arrayOf("title1")
        val count = db.update(
            FeedReaderContract.FeedEntry.TABLE_NAME,
            values,
            selection,
            selectionArgs
        )
        Log.i(TAG, "perform update data, result:$count")
    }

    @SuppressLint("Range")
    private fun queryData() {
        val db: SQLiteDatabase = dbHelper!!.getReadableDatabase()

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        val projection = arrayOf(
            BaseColumns._ID,
            FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
            FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE
        )

        // Filter results WHERE "title" = 'My Title'
        val selection: String = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE.toString() + " = ?"
        val selectionArgs = arrayOf("my_title")

        // How you want the results sorted in the resulting Cursor
        val sortOrder: String = FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE.toString() + " DESC"
        val cursor = db.query(
            FeedReaderContract.FeedEntry.TABLE_NAME,  // The table to query
            projection,  // The array of columns to return (pass null to get all)
            null,  // The columns for the WHERE clause
            null,  // The values for the WHERE clause
            null,  // don't group the rows
            null,  // don't filter by row groups
            sortOrder // The sort order
        )
        Log.i(TAG, "perfrom query data:")
        while (cursor.moveToNext()) {
            val itemId = cursor.getLong(cursor.getColumnIndexOrThrow("_id"))
            val title = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE))
            val subTitle = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE))
            Log.i(
                TAG,
                "itemId:$itemId, title:$title, subTitle:$subTitle"
            )
        }
        cursor.close()
    }

    private inner class WorkHander(looper: Looper?) : Handler(looper!!) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                Databasemodel.MSG_ADD_DATA -> addData()
                Databasemodel.MSG_DELETE_DATA -> deleteData()
                Databasemodel.MSG_UPDATE_DATA -> updateData()
                Databasemodel.MSG_QUERY_DATA -> queryData()
                else -> {}
            }
        }


    }

    companion object {
        private const val TAG = "DatabaseActivity"
    }
}
