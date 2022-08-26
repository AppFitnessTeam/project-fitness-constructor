package com.example.fitnessconstructor.domain

import kotlinx.coroutines.flow.Flow

interface CreateWorkoutUseCase {

    suspend fun createWorkout(workout: Workout)

    /**
     * Asynch fun to get exercises from data for create workout
     */
    suspend fun getAllExercises(): List<Exercise>

    suspend fun addExerciseToWorkout(exercise: Exercise)
    suspend fun removeExerciseFromWorkout(exercise: Exercise)

    /**
     * Asynch fun to get exercises of workout for viewModel (transformation to LiveData)
     */
    fun getWorkoutExercises(): Flow<StepWorkout>

    suspend fun deleteWorkout()
}