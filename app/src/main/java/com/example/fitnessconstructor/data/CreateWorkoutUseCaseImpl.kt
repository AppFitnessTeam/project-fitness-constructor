package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.database.CreateWorkoutDao
import com.example.fitnessconstructor.database.entities.WorkoutEntity
import com.example.fitnessconstructor.database.entities.WorkoutExercisesEntity
import com.example.fitnessconstructor.database.entities.WorkoutNotificationEntity
import com.example.fitnessconstructor.database.entities.WorkoutRestEntity
import com.example.fitnessconstructor.domain.CreateWorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.Workout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateWorkoutUseCaseImpl @Inject constructor(
    private val createWorkoutDao: CreateWorkoutDao
) : CreateWorkoutUseCase {

    private var workoutExercises: WorkoutExercises? = null

    override suspend fun createWorkout(workout: Workout) {
        withContext(Dispatchers.IO) {
            createWorkoutDao.createWorkout(
                WorkoutEntity(
                    name = workout.name,
                    day = workout.day,
                    userName = workout.name
                )
            )

            val workoutId = createWorkoutDao.getLastIdWorkoutEntity()
            createWorkoutDao.setRestToNewWorkout(
                WorkoutRestEntity(
                    workoutId = workoutId
                )
            )
            createWorkoutDao.setNotificationToNewWorkout(
                WorkoutNotificationEntity(
                    workoutId = workoutId
                )
            )
        }
    }

    override suspend fun getLastWorkoutId(): Int =
        withContext(Dispatchers.IO) {
            return@withContext createWorkoutDao.getLastIdWorkoutEntity()
        }

    override suspend fun getExercisesByDay(workoutId: Int, day: Int): List<Exercise> =
        withContext(Dispatchers.IO) {
            workoutExercises = WorkoutExercises.getInstance(workoutId, createWorkoutDao)
            return@withContext workoutExercises!!.getExercisesByDay(day)
        }

    override suspend fun getAllExercises(): List<Exercise> =
        withContext(Dispatchers.IO) {
            return@withContext createWorkoutDao.getAllExercises().map { it.toExercise() }
        }

    override suspend fun addExerciseToWorkout(
        workoutId: Int,
        day: Int,
        exerciseId: Int,
        count: Int
    ) =
        withContext(Dispatchers.IO) {
            createWorkoutDao.addExercise(
                WorkoutExercisesEntity(
                    workoutId = workoutId,
                    day = day,
                    exerciseId = exerciseId,
                    count = count
                )
            )
        }
}

private class WorkoutExercises(val workoutId: Int, private val createWorkoutDao: CreateWorkoutDao) {

    private val mapExercises = mutableMapOf<Int, MutableList<Exercise>>()

    fun getExercisesByDay(day: Int): MutableList<Exercise> {
        return mapExercises.getOrPut(day) { mutableListOf() }
    }

    fun addExercise(day: Int, exercise: Exercise) {
        mapExercises[day]?.add(exercise)
    }

    suspend fun initMapExercises() {
        val exerciseEntityList = createWorkoutDao.getWorkoutExercises(workoutId)
        exerciseEntityList.forEach {
            val keyMap = it.workoutExercisesEntity.day
            if (!mapExercises.containsKey(keyMap)) mapExercises[keyMap] = mutableListOf()
            mapExercises[keyMap]!!.add(it.toExercise())
        }
    }

    companion object {
        private var INSTANCE: WorkoutExercises? = null

        suspend fun getInstance(
            workoutId: Int,
            createWorkoutDao: CreateWorkoutDao
        ): WorkoutExercises {
            if (INSTANCE == null || INSTANCE!!.workoutId != workoutId) INSTANCE =
                WorkoutExercises(workoutId, createWorkoutDao).also { it.initMapExercises() }
            return INSTANCE!!
        }
    }
}
