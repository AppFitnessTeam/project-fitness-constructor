package com.example.fitnessconstructor.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Class for exercises
 * @param type STEP or TIME
 * @param count for amount or time of exercises
 */
@Parcelize
data class Exercise(
    val id: Int,
    override val name: String,
    override val type: ExerciseType,
    override var count: Int = 0 //TODO("change var to val when working with real database")
) : StepWorkout, Parcelable