package com.example.fitnessconstructor.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fitnessconstructor.database.entities.AllExercisesEntity
import com.example.fitnessconstructor.database.entities.ExercisesEntity
import com.example.fitnessconstructor.database.entities.WorkoutEntity
import com.example.fitnessconstructor.database.entities.WorkoutExercisesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CreateWorkoutDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createWorkout(workout: WorkoutEntity)

    @Query("SELECT * FROM all_exercises")
    suspend fun getAllExercises(): List<AllExercisesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExercise(exercise: WorkoutExercisesEntity)

    @Query("SELECT * FROM workout_exercises WHERE workout_id IS :workoutId AND day IS :day")
    fun getWorkoutExercises(workoutId: Int?, day: Int?): Flow<List<ExercisesEntity>>

    @Query("DELETE FROM workout")
    fun deleteAllWorkouts()
}

