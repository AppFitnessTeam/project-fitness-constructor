package com.example.fitnessconstructor.domain.entities

import java.sql.Time
import java.time.DayOfWeek

data class WorkoutSettings(
    val workoutId: Int,
    val workoutName: String,
    val arrpRest: Int,
    val exerciseRest: Int,
    val weekList: Map<DayOfWeek, Time?> //TODO("think about variable type")
)