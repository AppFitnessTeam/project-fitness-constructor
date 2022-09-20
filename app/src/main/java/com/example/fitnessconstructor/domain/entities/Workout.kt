package com.example.fitnessconstructor.domain.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.example.fitnessconstructor.database.entities.WorkoutEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Workout(
    val id: Int,
    val name: String,
    val stepsWorkout: MutableList<StepWorkout>, //TODO("not need, remove later")
    val day: Int?,
    val userName: String?
) : Parcelable