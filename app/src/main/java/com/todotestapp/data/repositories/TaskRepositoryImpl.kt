package com.todotestapp.data.repositories

import com.todotestapp.data.persistence.TempTaskStore
import com.todotestapp.domain.models.TaskModel
import com.todotestapp.domain.repositories.ITaskRepository

class TaskRepositoryImpl : ITaskRepository {
    private val tempDb = TempTaskStore()

    override fun getAll(): List<TaskModel> = tempDb.getAllTasks()


    override fun getById(id: Int): TaskModel? {
        TODO("Not yet implemented")
    }

    override fun update(task: TaskModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun insert(task: TaskModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteAll(): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}