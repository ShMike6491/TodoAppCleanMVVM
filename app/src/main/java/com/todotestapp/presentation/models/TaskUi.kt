package com.todotestapp.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

private const val DEFAULT_DATE = "00/00/00"

@Parcelize
data class TaskUi(
    val id: Int = 0,
    var title: String,
    var completed: Boolean = false,

    // на случай дополнительного функционала
    var important: Boolean = false,
    val created: String = DEFAULT_DATE
) : Parcelable