package com.example.myapplication.todolist.ui

import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.todolist.NoteOperator
import com.example.myapplication.todolist.beans.Note
import com.example.myapplication.todolist.beans.State
import java.text.SimpleDateFormat
import java.util.*

class NoteViewHolder(itemView: View, operator: NoteOperator) :
    RecyclerView.ViewHolder(itemView) {
    private val operator: NoteOperator
    private val checkBox: CheckBox
    private val contentText: TextView
    private val dateText: TextView
    private val deleteBtn: View
    fun bind(note: Note) {
        contentText.setText(note.content)
        dateText.text = SIMPLE_DATE_FORMAT.format(note.date)
        checkBox.setOnCheckedChangeListener(null)
        checkBox.isChecked = note.state === State.DONE
        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            note.state=(if (isChecked) State.DONE else State.TODO)
            Log.d(
                "NoteViewHolder",
                "In NoteViewHolder In onCheckedChanged State: " + note.state
            )
            operator.updateNote(note)
            if (note.state === State.DONE) {
                contentText.setTextColor(Color.GRAY)
                contentText.paintFlags =
                    contentText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                // TODO 为不同优先级设置不同颜色
                if (note.priority=== 2) {
                    contentText.setTextColor(Color.rgb(255, 246, 143))
                    contentText.setBackgroundColor(Color.rgb(153, 204, 255))
                } else if (note.priority === 3) {
                    contentText.setTextColor(Color.rgb(205, 92, 92))
                    contentText.setBackgroundColor(Color.rgb(153, 204, 255))
                } else {
                    contentText.setTextColor(Color.rgb(202, 255, 112))
                    contentText.setBackgroundColor(Color.rgb(153, 204, 255))
                }
                contentText.paintFlags =
                    contentText.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }
        deleteBtn.setOnClickListener { operator.deleteNote(note) }
        Log.d("NoteViewHolder",
            "In NoteViewHolder State: " + note.state
                .toString() + "  note.getState() == State.DONE: " + (note.state=== State.DONE)
        )
        Log.d("NoteViewHolder", "priority:" + note.priority)
        if (note.state === State.DONE) {
            contentText.paintFlags = contentText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {

            // TODO 为不同优先级设置不同颜色
            if (note.priority === 2) {
                contentText.setTextColor(Color.rgb(255, 246, 143))
                contentText.setBackgroundColor(Color.rgb(153, 204, 255))
            } else if (note.priority === 3) {
                contentText.setTextColor(Color.rgb(205, 92, 92))
                contentText.setBackgroundColor(Color.rgb(153, 204, 255))
            } else {
                contentText.setTextColor(Color.rgb(202, 255, 112))
                contentText.setBackgroundColor(Color.rgb(153, 204, 255))
            }
            contentText.paintFlags = contentText.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    companion object {
        private val SIMPLE_DATE_FORMAT =
            SimpleDateFormat("EE,HH:mm:ss  yyyy MM.dd ", Locale.CHINESE)
    }

    init {
        this.operator = operator
        checkBox = itemView.findViewById(R.id.checkbox)
        contentText = itemView.findViewById(R.id.text_content)
        dateText = itemView.findViewById(R.id.text_date)
        deleteBtn = itemView.findViewById(R.id.btn_delete)
    }
}
