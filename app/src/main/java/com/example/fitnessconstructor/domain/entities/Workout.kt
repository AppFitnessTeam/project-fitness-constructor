package com.example.fitnessconstructor.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Workout(
    val id: Int,
    val name: String,
    val nameRus: String,
    val isInList: Int?,
    val day: Int?,
    val userName: String?,
    val lvl: String?
) : Parcelable