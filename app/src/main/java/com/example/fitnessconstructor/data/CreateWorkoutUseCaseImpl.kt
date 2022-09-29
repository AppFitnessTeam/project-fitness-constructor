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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateWorkoutUseCaseImpl @Inject constructor(
    private val createWorkoutDao: CreateWorkoutDao
) : CreateWorkoutUseCase {

    override suspend fun createWorkout(workout: Workout) {
        createWorkoutDao.createWorkout(
            WorkoutEntity(
                name = workout.name,
                nameRus = workout.nameRus,
                isInList = workout.isInList,
                day = workout.day,
                userName = workout.name,
                lvl = workout.lvl
            )
        )

        createWorkoutDao.setRestToNewWorkout(
            WorkoutRestEntity(
                workoutId = workout.id
            )
        )

        createWorkoutDao.setNotificationToNewWorkout(
            WorkoutNotificationEntity(
                workoutId = workout.id
            )
        )
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
                    day = day.toString(),
                    exerciseId = exerciseId,
                    count = count
                )
            )
        }

    override fun getWorkoutExercises(workoutId: Int, day: Int): Flow<List<Exercise>> {
        return createWorkoutDao.getWorkoutExercises(workoutId, day).map { list ->
            list.map { it.toExercise() }
        }
    }
}
