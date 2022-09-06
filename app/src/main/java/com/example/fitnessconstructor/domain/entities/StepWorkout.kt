package com.example.fitnessconstructor.domain.entities

import android.os.Parcelable

interface StepWorkout : Parcelable {
    val name: String
    val type: ExerciseType
    val count: Int
}

enum class ExerciseType {
    STEP, TIME, STRESS
}