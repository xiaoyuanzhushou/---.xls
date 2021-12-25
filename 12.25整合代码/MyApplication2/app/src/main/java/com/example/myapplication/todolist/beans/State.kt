package com.example.myapplication.todolist.beans

enum class State(val intValue: Int) {
    TODO(0), DONE(1);

    companion object {
        fun from(intValue: Int): State {
            for (state in com.example.myapplication.todolist.beans.State.values()) {
                if (state.intValue == intValue) {
                    return state
                }
            }
            return TODO // default
        }

        fun refrom(state: State): Int {
            return if (state == DONE) 1 else 0
        }
    }
}
