package com.todotestapp.data.repositories

import com.todotestapp.data.mappers.asDatabaseModel
import com.todotestapp.data.mappers.asDomainModel
import com.todotestapp.domain.models.TaskModel
import com.todotestapp.domain.repositories.ITaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl(private val localStorage: ILocalStorage) : ITaskRepository {
    // решил приводить типы в репозитории, чтобы конкретные интерфейсы
    // не имели информацию о моделях domain слоя
    override fun getAll(): Flow<List<TaskModel>> =
        localStorage.getAll().map { it.asDomainModel() }

    override suspend fun getById(id: Int): TaskModel? =
        localStorage.findById(id)?.asDomainModel()

    override suspend fun update(task: TaskModel): Boolean {
        localStorage.update(task.asDatabaseModel())
        return true
    }

    override suspend fun insert(task: TaskModel): Boolean {
        localStorage.insert(task.asDatabaseModel())
        return true
    }

    override suspend fun deleteAll(): Boolean {
        localStorage.deleteAll()
        return true
    }

    override suspend fun deleteById(id: Int): Boolean {
        localStorage.deleteById(id)
        return true
    }
}