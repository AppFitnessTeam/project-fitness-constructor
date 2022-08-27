package com.example.fitnessconstructor.data

import androidx.annotation.VisibleForTesting
import com.example.fitnessconstructor.domain.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkoutUseCaseImpl @Inject constructor() : WorkoutUseCase {

    @Inject
    lateinit var repository: FakeRepository //TODO ("change when working with real database")

    override fun getWorkoutsList(): Flow<Workout> {
        TODO("Not yet implemented")
    }

    override fun getStepsWorkout(workout: Workout): Flow<StepWorkout> {
        val exercises = getWorkoutExercises(workout)
        val rest = getWorkoutRest(workout)
        return createStepsWorkout(exercises, rest).asFlow()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun createStepsWorkout(exercises: List<Exercise>, rest: List<Rest>): List<StepWorkout> {
        val result = mutableListOf<StepWorkout>()
        for (i in exercises.indices) {
            result.add(exercises[i])
            try {
                val isApproach = exercises[i].id == exercises[i + 1].id
                if (isApproach) result.add(rest[0]) else result.add(rest[1])
            } catch (andArray: IndexOutOfBoundsException){}
        }
        return result
    }

    private fun getWorkoutRest(workout: Workout): List<Rest> {
        TODO("Not yet implemented")
    }

    private fun getWorkoutExercises(workout: Workout): List<Exercise> {
        TODO("Not yet implemented")
    }
}