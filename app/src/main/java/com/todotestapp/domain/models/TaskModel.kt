package com.todotestapp.domain.models

import java.text.DateFormat

data class TaskModel(
    val id: Int = 0,
    var title: String,
    var completed: Boolean = false,

    // на случай дополнительного функционала
    var important: Boolean = false,
    val created: Long = System.currentTimeMillis()
) {
    fun dateFormatted (): String =
        DateFormat.getDateTimeInstance().format(created)
}