package com.todotestapp.domain.usecases

import com.todotestapp.domain.models.TaskModel
import com.todotestapp.domain.repositories.ITaskRepository

class MakeNewTaskUseCase(private val repository: ITaskRepository) {
    fun execute(task: TaskModel) = repository.insert(task)
}