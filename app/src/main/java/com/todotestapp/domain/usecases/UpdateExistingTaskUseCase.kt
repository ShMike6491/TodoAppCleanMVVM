package com.todotestapp.domain.usecases

import com.todotestapp.domain.models.TaskModel
import com.todotestapp.domain.repositories.ITaskRepository

class UpdateExistingTaskUseCase(private val repository: ITaskRepository) {
    suspend fun execute(task: TaskModel) = repository.update(task)
}