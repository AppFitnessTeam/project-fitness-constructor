package com.example.fitnessconstructor.database

import androidx.room.*
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.Workout
import kotlinx.coroutines.flow.Flow

@Dao
interface CreateWorkoutDao {

    //create workout
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createWorkout(workout: Workout)

    //editWorkout
    @Update
    suspend fun editWorkout(workout: Workout)

    //getAllExercises
    @Query("SELECT * FROM all_exercises")
    fun getExercise(): Flow<List<Exercise>>

    //addExerciseToWorkout
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addExercise(exercise: Exercise)

    //removeExerciseFromWorkout
    @Delete
    fun deleteExerciseFromWorkout(exercise: Exercise)

    //deleteWorkout
    @Query("DELETE FROM workout")
    fun deleteWorkout()

}

