package com.todotestapp.presentation.models

private const val DEFAULT_DATE = "00/00/00"

data class TaskUi(
    val id: Int = 0,
    var title: String,
    var completed: Boolean = false,

    // на случай дополнительного функционала
    var important: Boolean = false,
    val created: String = DEFAULT_DATE
)