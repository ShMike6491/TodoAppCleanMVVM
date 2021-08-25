package com.todotestapp.data.mappers

import com.todotestapp.data.persistence.entities.TaskEntity
import com.todotestapp.domain.models.TaskModel

/**
 * Extension function to convert a list of database entities to domain data model
 */
fun List<TaskEntity>.asDomainModel(): List<TaskModel> = map {
    it.asDomainModel()
}

/**
 * Extension function to convert a database entity to domain data model
 */
fun TaskEntity.asDomainModel(): TaskModel = TaskModel(
    id = id,
    title = title,
    completed = completed,
    important = important,
    created = created
)

/**
 * Extension function to convert a domain model to database entity
 */
fun TaskModel.asDatabaseModel(): TaskEntity = TaskEntity(
    id = id,
    title = title,
    completed = completed,
    important = important,
    created = created
)

