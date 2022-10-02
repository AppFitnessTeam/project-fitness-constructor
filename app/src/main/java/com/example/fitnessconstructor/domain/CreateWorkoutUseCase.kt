package com.example.fitnessconstructor.domain

import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.Workout

interface CreateWorkoutUseCase {

    suspend fun createWorkout(workout: Workout)
    suspend fun getLastWorkoutId(): Int

    suspend fun getExercisesByDay(workoutId: Int, day: Int): List<Exercise>
    suspend fun updateExercisesByDay(day: Int, exercises: List<Exercise>)

    /**
     * Asynch fun to get exercises from data for create workout
     */
    suspend fun getAllExercises(): List<Exercise>

    fun addExerciseToWorkout(workoutId: Int, day: Int, exercise: Exercise)
    suspend fun saveWorkout()
}