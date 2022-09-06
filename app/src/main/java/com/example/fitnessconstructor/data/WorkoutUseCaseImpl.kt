package com.example.fitnessconstructor.data

import androidx.annotation.VisibleForTesting
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.Rest
import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.domain.entities.Workout
import com.example.fitnessconstructor.database.WorkoutDao
import com.example.fitnessconstructor.database.entities.toListRest
import com.example.fitnessconstructor.database.entities.toWorkout
import com.example.fitnessconstructor.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkoutUseCaseImpl @Inject constructor(
    private val workoutDao: WorkoutDao
) : WorkoutUseCase {

    override fun getWorkoutsList(): Flow<List<Workout>> {
        return workoutDao.getWorkout().map {
            it.map { workoutEntity ->
                workoutEntity.toWorkout()
            }
        }
    }

    override fun getWorkoutExercises(workoutId: Int): Flow<List<StepWorkout>> {
        workoutDao.getWorkoutExercises(workoutId)
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

    private suspend fun getWorkoutRest(workout: Workout): List<Rest> =
        withContext(Dispatchers.IO) {
            return@withContext workoutDao.getWorkoutRest(workout.id).toListRest()
        }

    private fun getWorkoutExercises(workout: Workout): List<Exercise> =
        TODO("Not yet implemented")
    }
}