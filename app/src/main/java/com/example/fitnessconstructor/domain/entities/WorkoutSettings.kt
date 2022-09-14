package com.example.fitnessconstructor.domain.entities

import java.sql.Time
import java.time.DayOfWeek

data class WorkoutSettings(
    val workoutId: Int,
    val workoutName: String,
    val workoutUserName: String?,
    val apprRest: Int,
    val exerciseRest: Int,
   // val week: Map<DayOfWeek, Time?>?
)
