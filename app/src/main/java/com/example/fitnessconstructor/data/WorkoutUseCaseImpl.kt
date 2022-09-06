package com.example.fitnessconstructor.data

import androidx.annotation.VisibleForTesting
import com.example.fitnessconstructor.database.WorkoutDao
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.Rest
import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.domain.entities.Workout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
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

    override suspend fun getWorkoutExercises(workoutId: Int, day: Int): List<Exercise> =
        withContext(Dispatchers.IO) {
            return@withContext workoutDao.getWorkoutExercises(workoutId, day).map {
                it.toExercise()
            }
        }

    override suspend fun getWorkoutSteps(workoutId: Int, day: Int): List<StepWorkout> {
        val exercises = getWorkoutExercises(workoutId, day)
        val rest = getWorkoutRest(workoutId)
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

    private suspend fun getWorkoutRest(workoutId: Int): List<Rest> =
        withContext(Dispatchers.IO) {
            return@withContext workoutDao.getWorkoutRest(workoutId).toListRest()
        }
}