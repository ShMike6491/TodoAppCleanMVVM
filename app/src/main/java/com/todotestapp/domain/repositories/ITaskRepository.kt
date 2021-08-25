package com.todotestapp.domain.repositories

import com.todotestapp.domain.models.TaskModel

interface ITaskRepository {
    fun getAll(): List<TaskModel>
    fun getById(id: Int): TaskModel?
    fun update(task: TaskModel): Boolean
    fun insert(task: TaskModel): Boolean
    fun deleteAll(): Boolean
    fun deleteById(id: Int): Boolean
}