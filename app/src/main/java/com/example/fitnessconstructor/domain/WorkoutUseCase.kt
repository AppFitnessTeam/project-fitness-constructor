package com.example.fitnessconstructor.domain

import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.domain.entities.Workout
import kotlinx.coroutines.flow.Flow

interface WorkoutUseCase {
    /**
     * Asynch fun to get user's workouts from data for viewModel (transformation to LiveData)
     */
    fun getWorkoutsList(): Flow<List<Workout>>

    fun getExercisesWorkout(workout: Workout): Flow<List<Exercise>>
}