package com.example.fitnessconstructor.domain.entities

import java.sql.Time
import java.time.DayOfWeek

data class WorkoutSettings(
    val workoutId: Int,
    val workoutName: String,
    val workoutUserName: String?,
    val setsRest: Int,
    val exerciseRest: Int,
    val weekList: List<Pair<DayOfWeek, Time?>> //TODO("think about variable type")
)
