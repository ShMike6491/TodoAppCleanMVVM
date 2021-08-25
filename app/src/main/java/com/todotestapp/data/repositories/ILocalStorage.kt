package com.todotestapp.data.repositories

import com.todotestapp.data.persistence.entities.TaskEntity

interface ILocalStorage {
    fun getAll(): List<TaskEntity>
    fun findById(id: Int): TaskEntity?
    fun update(task: TaskEntity)
    fun insert(task: TaskEntity)
    fun deleteAll()
    fun deleteById(id: Int)
}