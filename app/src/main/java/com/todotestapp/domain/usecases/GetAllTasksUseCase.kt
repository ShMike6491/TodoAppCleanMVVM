package com.todotestapp.domain.usecases

import com.todotestapp.domain.models.TaskModel
import com.todotestapp.domain.repositories.ITaskRepository

class GetAllTasksUseCase(private val repository: ITaskRepository) {
    fun execute(): List<TaskModel> = repository.getAll()
}