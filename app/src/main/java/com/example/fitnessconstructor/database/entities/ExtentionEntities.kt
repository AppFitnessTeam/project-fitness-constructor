package com.example.fitnessconstructor.database.entities

import com.example.fitnessconstructor.domain.entities.ExerciseType

fun getTypeExerciseById(typeId: Int): ExerciseType {
    return when (typeId) {
        1 -> ExerciseType.STRESS
        2 -> ExerciseType.STEP
        3 -> ExerciseType.TIME
        else -> {
            throw IllegalArgumentException("Incorrect typeId")
        }
    }
}