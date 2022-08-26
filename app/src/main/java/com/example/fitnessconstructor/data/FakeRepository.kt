package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeRepository @Inject constructor() {

    private val exercisesList = createAllExercises()
    private val workoutsList = mutableListOf<Workout>().apply { addAll(createWorkoutList()) }

    private val exercisesStressList = createStressExercises()

    fun addWorkout(workout: Workout) {
        workoutsList.add(workout)
    }

    fun addExerciseToWorkout(stepWorkout: StepWorkout, workout: Workout) {
        findWorkout(workout).stepsWorkout.add(stepWorkout)
    }

    fun getWorkoutsList(): Flow<List<Workout>> {
        return flow<List<Workout>> { emit(workoutsList) }.flowOn(Dispatchers.IO)
    }

    fun getAllExercises(): List<Exercise> = exercisesList

    fun getWorkoutExercises(workout: Workout): Flow<StepWorkout> {
        return (findWorkout(workout).stepsWorkout).asFlow().flowOn(Dispatchers.IO)
    }

    fun removeWorkout(workout: Workout) {
        workoutsList.remove(workout)
    }

    fun removeExerciseFromWorkout(stepWorkout: StepWorkout, workout: Workout) {
        findWorkout(workout).stepsWorkout.remove(stepWorkout)
    }

    fun removeAll() {
        workoutsList.clear()
    }

    fun getStressWorkout(): Workout {
        return Workout(
            id = 0,
            name = "Stress workout",
            stepsWorkout = mutableListOf<StepWorkout>().apply {
                add(exercisesStressList[0].apply { count = 30 })
                add(exercisesStressList[1].apply { count = 30 })
                add(exercisesStressList[2].apply { count = 30 })
            }
        )
    }

    private fun createStressExercises(): List<Exercise> {
        return listOf(
            Exercise(id = 0, name = "Push aps", ExerciseType.STRESS),
            Exercise(id = 1, name = "Squats", ExerciseType.STRESS),
            Exercise(id = 2, name = "Running in place", ExerciseType.STRESS)
        )
    }

    private fun createAllExercises(): List<Exercise> {
        return listOf(
            Exercise(id = 0, name = "Push aps", ExerciseType.STEP),
            Exercise(id = 1, name = "Squats", ExerciseType.STEP),
            Exercise(id = 2, name = "Crunches", ExerciseType.STEP),
            Exercise(id = 3, name = "Pull aps", ExerciseType.STEP)
        )
    }

    private fun generateRest(count: Int): Rest = Rest(count = count)

    private fun findWorkout(workout: Workout): Workout {
        return workoutsList.find { it == workout }
            ?: throw NoSuchElementException("Can't find $workout")
    }

    private fun createWorkoutList(): List<Workout> {
        return listOf(
            Workout(
                id = 0,
                name = "Workout 1",
                stepsWorkout = mutableListOf<StepWorkout>().apply {
                    add(exercisesList[0].apply { count = 20 })
                    add(generateRest(20))
                    add(exercisesList[3].apply { count = 30 })
                }
            ),
            Workout(
                id = 1,
                name = "Workout 2",
                stepsWorkout = mutableListOf<StepWorkout>().apply {
                    add(exercisesList[1].apply { count = 30 })
                    add(generateRest(30))
                    add(exercisesList[2].apply { count = 40 })
                }
            ),
        )
    }
}