package com.example.fitnessconstructor.database

import androidx.room.*
import com.example.fitnessconstructor.domain.entities.Exercise
import kotlinx.coroutines.flow.Flow

@Dao
interface CreateWorkoutDao {

    //create workout
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createWorkout(workout: Int?)

    //editWorkout
    @Update
    suspend fun editWorkout(workout: Int?)

    //getAllExercises
    @Query("SELECT * FROM all_exercises")
    fun getExercise(): Flow<List<Exercise>>

    //addExerciseToWorkout
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addExercise(exercise: Int?)

    //removeExerciseFromWorkout
    @Delete
    fun deleteExerciseFromWorkout(exercise: Int?)

    //deleteWorkout
    @Query("DELETE FROM workout")
    fun deleteWorkout()

}

