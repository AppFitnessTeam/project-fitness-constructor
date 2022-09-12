package com.example.fitnessconstructor.domain

import com.example.fitnessconstructor.domain.entities.WorkoutSettings

interface WorkoutSettingsUseCase {
    suspend fun getWorkoutSettings(): WorkoutSettings
    suspend fun updateWorkoutSettings(workoutSettings: WorkoutSettings)
}