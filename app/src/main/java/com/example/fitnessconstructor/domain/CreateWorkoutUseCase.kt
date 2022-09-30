package com.example.fitnessconstructor.domain

import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.Workout
import kotlinx.coroutines.flow.Flow

interface CreateWorkoutUseCase {

    suspend fun createWorkout(workout: Workout)
    suspend fun getLastWorkoutId(): Int

    /**
     * Asynch fun to get exercises from data for create workout
     */
    suspend fun getAllExercises(): List<Exercise>

    suspend fun addExerciseToWorkout(workoutId: Int, day: Int, exerciseId: Int, count: Int)

    fun getWorkoutExercises(workoutId: Int, day: Int): Flow<List<Exercise>>
}