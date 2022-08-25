package com.example.fitnessconstructor.domain

import kotlinx.coroutines.flow.Flow

interface WorkoutUseCase {
    /**
     * Asynch fun to get user's workouts from data for viewModel (transformation to LiveData)
     */
    fun getWorkoutsList(): Flow<Workout>
}