package com.todotestapp.domain.repositories

import com.todotestapp.domain.models.TaskModel
import kotlinx.coroutines.flow.Flow

interface ITaskRepository {
    fun getAll(): Flow<List<TaskModel>>
    suspend fun getById(id: Int): TaskModel?
    suspend fun update(task: TaskModel): Boolean
    suspend fun insert(task: TaskModel): Boolean
    suspend fun deleteAll(): Boolean
    suspend fun deleteById(id: Int): Boolean
}