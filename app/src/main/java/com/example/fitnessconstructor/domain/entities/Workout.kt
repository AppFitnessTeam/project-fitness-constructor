package com.example.fitnessconstructor.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Workout(
    val id: Int = 0,
    val name: String,
    val nameRus: String? = null,
    val isInList: Int = 1,
    val day: Int = 1,
    val userName: String? = null,
    val lvl: String? = null
) : Parcelable