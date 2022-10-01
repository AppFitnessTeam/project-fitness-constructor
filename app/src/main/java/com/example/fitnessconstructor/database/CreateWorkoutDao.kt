package com.example.fitnessconstructor.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fitnessconstructor.database.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CreateWorkoutDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createWorkout(workout: WorkoutEntity)

    @Query("SELECT MAX(id) FROM workout")
    suspend fun getLastIdWorkoutEntity(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setRestToNewWorkout(workoutRestEntity: WorkoutRestEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setNotificationToNewWorkout(workoutNotificationEntity: WorkoutNotificationEntity)

    @Query("SELECT * FROM all_exercises")
    suspend fun getAllExercises(): List<AllExercisesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExercise(exercise: WorkoutExercisesEntity)

    @Query("SELECT * FROM workout_exercises WHERE workout_id = :workoutId")
    suspend fun getWorkoutExercises(workoutId: Int): List<ExercisesEntity>

    @Query("DELETE FROM workout")
    fun deleteAllWorkouts()
}

