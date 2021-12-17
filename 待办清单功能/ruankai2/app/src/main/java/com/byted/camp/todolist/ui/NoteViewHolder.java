package com.byted.camp.todolist.ui;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.byted.camp.todolist.NoteOperator;
import com.byted.camp.todolist.R;
import com.byted.camp.todolist.beans.Note;
import com.byted.camp.todolist.beans.State;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;


public class NoteViewHolder extends RecyclerView.ViewHolder {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT =
            new SimpleDateFormat("EE,HH:mm:ss  yyyy MM.dd ", Locale.CHINESE);

    private final NoteOperator operator;

    private CheckBox checkBox;
    private TextView contentText;
    private TextView dateText;
    private View deleteBtn;

    public NoteViewHolder(@NonNull View itemView, NoteOperator operator) {
        super(itemView);
        this.operator = operator;

        checkBox = itemView.findViewById(R.id.checkbox);
        contentText = itemView.findViewById(R.id.text_content);
        dateText = itemView.findViewById(R.id.text_date);
        deleteBtn = itemView.findViewById(R.id.btn_delete);
    }

    public void bind(final Note note) {
        contentText.setText(note.getContent());
        dateText.setText(SIMPLE_DATE_FORMAT.format(note.getDate()));

        checkBox.setOnCheckedChangeListener(null);
        checkBox.setChecked(note.getState() == State.DONE);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                note.setState(isChecked ? State.DONE : State.TODO);
                Log.d("NoteViewHolder", "In NoteViewHolder In onCheckedChanged State: " + note.getState());
                operator.updateNote(note);
                if (note.getState() == State.DONE) {
                    contentText.setTextColor(Color.GRAY);
                    contentText.setPaintFlags(contentText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    // TODO 为不同优先级设置不同颜色
                    if (note.getPriority() == 2) {
                        contentText.setTextColor(Color.rgb(255, 246, 143));
                        contentText.setBackgroundColor(Color.rgb(135, 206, 250));
                    } else if (note.getPriority() == 3) {
                        contentText.setTextColor(Color.rgb(205, 92, 92));
                        contentText.setBackgroundColor(Color.rgb(135, 206, 250));
                    } else {
                        contentText.setTextColor(Color.rgb(202, 255, 112));
                        contentText.setBackgroundColor(Color.rgb(135, 206, 250));
                    }
                    contentText.setPaintFlags(contentText.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.deleteNote(note);
            }
        });

        Log.d("NoteViewHolder", "In NoteViewHolder State: "+ note.getState()+"  note.getState() == State.DONE: "+(note.getState() == State.DONE));
        Log.d("NoteViewHolder","priority:"+note.getPriority());
        if (note.getState() == State.DONE) {

            contentText.setPaintFlags(contentText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {

            // TODO 为不同优先级设置不同颜色
            if (note.getPriority() == 2) {
                contentText.setTextColor(Color.rgb(255,246,143));
                contentText.setBackgroundColor(Color.rgb(135,206,250));
            } else if (note.getPriority() == 3){
                contentText.setTextColor(Color.rgb(205,92 ,92));
                contentText.setBackgroundColor(Color.rgb(135,206,250));
            }
            else {
                contentText.setTextColor(Color.rgb(	202,255,112));
                contentText.setBackgroundColor(Color.rgb(135,206,250));
            }
            contentText.setPaintFlags(contentText.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
