package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.domain.CreateWorkoutUseCase
import com.example.fitnessconstructor.domain.Exercise
import com.example.fitnessconstructor.domain.StepWorkout
import com.example.fitnessconstructor.domain.Workout
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateWorkoutUseCaseImpl @Inject constructor() : CreateWorkoutUseCase {

    @Inject
    lateinit var repository: FakeRepository //TODO ("change when working with real database")

    override suspend fun createWorkout(workout: Workout) {
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

    override fun getWorkoutExercises(workout: Workout): Flow<StepWorkout> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWorkout(workout: Workout) {
        TODO("Not yet implemented")
    }
}
