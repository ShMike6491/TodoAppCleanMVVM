package com.todotestapp.domain.usecases

import com.todotestapp.domain.models.TaskModel
import com.todotestapp.domain.repositories.ITaskRepository

class MarkTaskAsDoneSwitchUseCase(private val repository: ITaskRepository) {
    fun execute(id: Int) {
        val task: TaskModel = repository.getById(id) ?: throw IllegalArgumentException()
        task.completed = !task.completed
        repository.update(task)
    }
}