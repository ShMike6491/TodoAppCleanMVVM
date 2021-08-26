package com.todotestapp.data.repositories

import com.todotestapp.data.persistence.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

interface ILocalStorage {
    fun getAll(): Flow<List<TaskEntity>>
    suspend fun findById(id: Int): TaskEntity?
    suspend fun update(task: TaskEntity)
    suspend fun insert(task: TaskEntity)
    suspend fun deleteAll()
    suspend fun deleteById(id: Int)
}