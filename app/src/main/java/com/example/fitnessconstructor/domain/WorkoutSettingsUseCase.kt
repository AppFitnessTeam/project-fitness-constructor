package com.example.fitnessconstructor.domain

import com.example.fitnessconstructor.domain.entities.WorkoutSettings

interface WorkoutSettingsUseCase {
    suspend fun getWorkoutSettings(workoutId: Int): WorkoutSettings
    suspend fun updateWorkoutSettings(workoutSettings: WorkoutSettings)
    suspend fun deleteWorkout(workoutId: Int)
}