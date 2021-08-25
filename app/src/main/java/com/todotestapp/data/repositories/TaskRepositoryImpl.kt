package com.todotestapp.data.repositories

import com.todotestapp.data.mappers.asDatabaseModel
import com.todotestapp.data.mappers.asDomainModel
import com.todotestapp.domain.models.TaskModel
import com.todotestapp.domain.repositories.ITaskRepository

class TaskRepositoryImpl(private val localStorage: ILocalStorage) : ITaskRepository {
    override fun getAll(): List<TaskModel> =
        localStorage.getAll().asDomainModel()


    override fun getById(id: Int): TaskModel? =
        localStorage.findById(id)?.asDomainModel()


    override fun update(task: TaskModel): Boolean {
        localStorage.update(task.asDatabaseModel())
        return true
    }

    override fun insert(task: TaskModel): Boolean {
        localStorage.insert(task.asDatabaseModel())
        return true
    }

    override fun deleteAll(): Boolean {
        localStorage.deleteAll()
        return true
    }

    override fun deleteById(id: Int): Boolean {
        localStorage.deleteById(id)
        return true
    }
}