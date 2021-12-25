package com.example.myapplication.todolist.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.todolist.NoteOperator
import com.example.myapplication.TodoListApplication
import com.example.myapplication.todolist.beans.Note
import com.example.myapplication.todolist.beans.State
import java.util.ArrayList
import java.util.Comparator


class NoteListAdapter(private val operator: NoteOperator) :
    RecyclerView.Adapter<NoteViewHolder>() {
    private val notes: MutableList<Note> = ArrayList()
    fun refresh(newNotes: List<Note>?) {
        notes.clear()
        if (newNotes != null) {
            notes.addAll(newNotes)
            //            notes.sort(Comparator.comparing());
            val sp: SharedPreferences = TodoListApplication.context!!
                .getSharedPreferences("sort", Context.MODE_MULTI_PROCESS)
            val isOpen = sp.getBoolean("isopen", false)
            Log.d("adapter", "isOpen:$isOpen")
            if (isOpen) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    //升序排序
                    notes.sortWith(object : Comparator<Note?> {
                        //返回正值即前值大于后值
                        override fun compare(n1: Note?, n2: Note?): Int {
                            return if (n1!!.state !== n2!!.state&&n1!!.state!=null&&n2!!.state!=null) {
                                //完成state==1，未完成state为0，即完成的放在未完成的后面
                                State.refrom(n1!!.state!!) - State.refrom(n2!!.state!!)
                            } else {
                                if (n1!!.priority !== n2!!.priority) {
                                    //优先级由1到3递减
                                    n2!!.priority - n1!!.priority
                                } else {
                                    n2!!.date!!.compareTo(n1!!.date)
                                }
                            }
                        }


                    })
                } else Log.e("data", "Build.VERSION.SDK_INT < Build.VERSION_CODES.N")
                for (item in notes) {
                    Log.d("data",
                        "In NoteListAdapter id:" + item.id
                            .toString() + " state:" + item.state
                            .toString() + " priority:" + item.priority
                    )
                }
                //todo 根据${com.byted.camp.todolist.operation.activity.SettingActivity中设置的sp控制是否将已完成的完成排到最后
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): NoteViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note_todo, parent, false)
        return NoteViewHolder(itemView, operator)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, pos: Int) {
        holder.bind(notes[pos])
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}
