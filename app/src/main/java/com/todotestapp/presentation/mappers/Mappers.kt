package com.todotestapp.presentation.mappers

import com.todotestapp.domain.models.TaskModel
import com.todotestapp.presentation.models.TaskUi

/**
 * Extension function to convert a list of domain entities to presenter model
 */
fun List<TaskModel>.asPresentationModel(): List<TaskUi> = map {
    TaskUi(
        id = it.id,
        title = it.title,
        completed = it.completed,
        important = it.important,
        created = it.dateFormatted()
    )
}

/**
 * Extension function to convert a presenter model to domain data model
 */
fun TaskUi.asDomainModel(): TaskModel = TaskModel(
    id = id,
    title = title,
    completed = completed,
    important = important
)