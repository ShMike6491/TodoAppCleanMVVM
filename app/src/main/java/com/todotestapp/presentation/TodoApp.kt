package com.todotestapp.presentation

import android.app.Application
import com.todotestapp.data.persistence.TaskDataBase

class TodoApp : Application() {
    val database by lazy { TaskDataBase.getDatabase(this) }
}