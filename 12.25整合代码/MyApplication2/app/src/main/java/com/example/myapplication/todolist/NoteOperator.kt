package com.example.myapplication.todolist


import com.example.myapplication.todolist.beans.Note


interface NoteOperator {
    fun deleteNote(note: Note?)
    fun updateNote(note: Note?)
}
