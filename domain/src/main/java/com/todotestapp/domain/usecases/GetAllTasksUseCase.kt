package com.todotestapp.domain.usecases

import com.todotestapp.domain.models.TaskModel
import com.todotestapp.domain.repositories.ITaskRepository
import kotlinx.coroutines.flow.Flow

class GetAllTasksUseCase(private val repository: ITaskRepository) {
    fun execute(): Flow<List<TaskModel>> = repository.getAll()
}