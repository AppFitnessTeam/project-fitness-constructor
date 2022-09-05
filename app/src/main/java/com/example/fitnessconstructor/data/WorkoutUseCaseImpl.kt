package com.example.fitnessconstructor.data

import androidx.annotation.VisibleForTesting
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.Rest
import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.domain.entities.Workout
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkoutUseCaseImpl @Inject constructor() : WorkoutUseCase {

    @Inject
    lateinit var repository: FakeRepository //TODO ("change when working with real database")

    override fun getWorkoutsList(): Flow<List<Workout>> {
        TODO("Not yet implemented")
    }

    override suspend fun getWorkoutExercises(workoutId: Int, day: Int): List<Exercise> {
        TODO("Not yet implemented")
    }

    override suspend fun getWorkoutSteps(workout: Workout, day: Int): List<StepWorkout> {
        val exercises = getWorkoutExercises(workout.id, day)
        val rest = getWorkoutRest(workout)
        return createStepsWorkout(exercises, rest)
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun createStepsWorkout(exercises: List<Exercise>, rest: List<Rest>): List<StepWorkout> {
        val result = mutableListOf<StepWorkout>()
        for (i in exercises.indices) {
            result.add(exercises[i])
            try {
                val isApproach = exercises[i].id == exercises[i + 1].id
                if (isApproach) result.add(rest[0]) else result.add(rest[1])
            } catch (andArray: IndexOutOfBoundsException) {
            }
        }
        return result
    }

    private suspend fun getWorkoutRest(workout: Workout): List<Rest> {
        TODO("Not yet implemented")
    }
}