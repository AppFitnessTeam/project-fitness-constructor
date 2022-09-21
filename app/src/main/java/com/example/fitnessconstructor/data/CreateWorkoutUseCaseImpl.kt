package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.domain.CreateWorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.domain.entities.Workout
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateWorkoutUseCaseImpl @Inject constructor() : CreateWorkoutUseCase {

    override suspend fun createWorkout() {
        TODO("Not yet implemented")
    }

    override suspend fun editWorkout(workout: Workout) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllExercises(): List<Exercise> {
        TODO("Not yet implemented")
    }

    override suspend fun addExerciseToWorkout(exercise: Exercise) {
        TODO("Not yet implemented")
    }

    override suspend fun removeExerciseFromWorkout(exercise: Exercise) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWorkout(workout: Workout) {
        TODO("Not yet implemented")
    }
}
