package com.todotestapp.presentation

import android.app.Application
import com.todotestapp.data.persistence.TaskDataBase
import com.todotestapp.data.repositories.TaskRepositoryImpl
import com.todotestapp.domain.usecases.GetAllTasksUseCase
import com.todotestapp.domain.usecases.MakeNewTaskUseCase
import com.todotestapp.domain.usecases.MarkTaskAsDoneSwitchUseCase
import com.todotestapp.domain.usecases.UpdateExistingTaskUseCase

class TodoApp : Application() {
    val database by lazy { TaskDataBase.getDatabase(this) }
    private val repository by lazy { TaskRepositoryImpl(database.taskDao()) }

    val markSwitchUseCase by lazy { MarkTaskAsDoneSwitchUseCase(repository) }
    val getAllTasksUseCase by lazy { GetAllTasksUseCase(repository) }
    val makeNewTaskUseCae by lazy { MakeNewTaskUseCase(repository) }
    val updateExistingUseCase by lazy { UpdateExistingTaskUseCase(repository) }
}