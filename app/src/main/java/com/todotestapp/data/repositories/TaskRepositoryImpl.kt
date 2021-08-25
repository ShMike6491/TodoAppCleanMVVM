package com.todotestapp.data.repositories

import com.todotestapp.domain.models.TaskModel
import com.todotestapp.domain.repositories.ITaskRepository

class TaskRepositoryImpl : ITaskRepository {
    override fun getAll(): List<TaskModel> {
        TODO("Not yet implemented")
    }

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