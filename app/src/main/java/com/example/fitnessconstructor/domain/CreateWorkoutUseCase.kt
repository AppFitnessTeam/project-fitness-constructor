package com.example.fitnessconstructor.domain

import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.domain.entities.Workout
import kotlinx.coroutines.flow.Flow

interface CreateWorkoutUseCase {

    suspend fun createWorkout()
    suspend fun editWorkout(workout: Workout)

    /**
     * Asynch fun to get exercises from data for create workout
     */
    suspend fun getAllExercises(): List<Exercise>

    suspend fun addExerciseToWorkout(exercise: Exercise)
    suspend fun removeExerciseFromWorkout(exercise: Exercise)
}