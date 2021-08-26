package com.todotestapp.data.persistence.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var title: String,
    var completed: Boolean = false,
    var important: Boolean = false,
    val created: Long = System.currentTimeMillis()
)