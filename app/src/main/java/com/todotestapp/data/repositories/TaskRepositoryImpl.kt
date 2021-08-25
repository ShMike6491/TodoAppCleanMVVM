package com.todotestapp.data.repositories

import com.todotestapp.data.persistence.TempTaskStore
import com.todotestapp.domain.models.TaskModel
import com.todotestapp.domain.repositories.ITaskRepository

class TaskRepositoryImpl : ITaskRepository {
    private val tempDb = TempTaskStore()

    override fun getAll(): List<TaskModel> =
        tempDb.getAllTasks()


    override fun getById(id: Int): TaskModel? =
        tempDb.findTaskById(id)


    override fun update(task: TaskModel): Boolean {
        tempDb.insertTask(task)
        return true
    }

    override fun insert(task: TaskModel): Boolean {
        tempDb.insertTask(task)
        return true
    }

    override fun deleteAll(): Boolean {
        tempDb.deleteAll()
        return true
    }

    override fun deleteById(id: Int): Boolean {
        tempDb.deleteById(id)
        return true
    }
}