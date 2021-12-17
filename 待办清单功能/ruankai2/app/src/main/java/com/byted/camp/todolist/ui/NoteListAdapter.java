package com.byted.camp.todolist.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.byted.camp.todolist.NoteOperator;
import com.byted.camp.todolist.R;
import com.byted.camp.todolist.TodoListApplication;
import com.byted.camp.todolist.beans.Note;
import com.byted.camp.todolist.beans.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;


public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private NoteOperator operator;
    private final List<Note> notes = new ArrayList<Note>();

    public NoteListAdapter(NoteOperator operator) {
        this.operator = operator;
    }





    public void refresh(List<Note> newNotes) {
            notes.clear();
            if (newNotes != null) {
                notes.addAll(newNotes);
//            notes.sort(Comparator.comparing());
                SharedPreferences sp = TodoListApplication.getContext().getSharedPreferences("sort",Context.MODE_MULTI_PROCESS);
                boolean isOpen = sp.getBoolean("isopen",false);

                Log.d("adapter", "isOpen:"+isOpen);
                if(isOpen){

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    //升序排序
                    notes.sort(new Comparator<Note>() {
                        @Override
                        //返回正值即前值大于后值
                        public int compare(Note n1, Note n2) {
                            if (n1.getState() != n2.getState()) {
                                //完成state==1，未完成state为0，即完成的放在未完成的后面
                                return State.refrom(n1.getState()) - State.refrom(n2.getState());
                            } else {
                                if (n1.getPriority() != n2.getPriority()) {
                                    //优先级由1到3递减
                                    return n2.getPriority() - n1.getPriority();
                                } else {
                                    return n2.getDate().compareTo(n1.getDate());
                                }
                            }
                        }
                    });
                } else
                    Log.e("data", "Build.VERSION.SDK_INT < Build.VERSION_CODES.N");
                for (Note item : notes) {
                    Log.d("data", "In NoteListAdapter id:" + item.getId() + " state:" + item.getState() + " priority:" + item.getPriority());
                }
                //todo 根据${com.byted.camp.todolist.operation.activity.SettingActivity} 中设置的sp控制是否将已完成的完成排到最后，默认不排序
            }
        }
            notifyDataSetChanged();



    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(itemView, operator);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int pos) {
        holder.bind(notes.get(pos));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
