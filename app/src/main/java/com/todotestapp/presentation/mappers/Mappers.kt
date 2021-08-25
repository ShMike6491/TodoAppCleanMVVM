package com.todotestapp.presentation.mappers

import com.todotestapp.domain.models.TaskModel
import com.todotestapp.presentation.models.TaskUi

fun List<TaskModel>.asPresentationModel(): List<TaskUi> = map {
    TaskUi(
        id = it.id,
        title = it.title,
        completed = it.completed,
        important = it.important,
        created = it.dateFormatted()
    )
}

fun TaskUi.asDomainModel(): TaskModel = TaskModel(
    id = id,
    title = title,
    completed = completed,
    important = important
)