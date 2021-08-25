package com.todotestapp.domain.models

import java.text.DateFormat

data class TaskModel(
    val id: Int = 0,
    val title: String,
    val completed: Boolean = false,

    // на случай дополнительного функционала
    val important: Boolean = false,
    val created: Long = System.currentTimeMillis()
) {
    fun dateFormatted (): String =
        DateFormat.getDateTimeInstance().format(created)
}