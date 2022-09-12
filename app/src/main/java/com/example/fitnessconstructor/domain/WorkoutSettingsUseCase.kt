package com.example.fitnessconstructor.domain

interface WorkoutSettingsUseCase {
    suspend fun setName(workoutName: String)
    suspend fun setApprRest(apprRest: Int)
    suspend fun setExerciseRest(exerciseRest: Int)
    suspend fun deleteWorkout(workoutId: Int)
}