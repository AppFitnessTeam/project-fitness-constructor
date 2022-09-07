package com.example.fitnessconstructor.database

import androidx.room.*
import com.example.fitnessconstructor.database.entities.WorkoutEntity
import com.example.fitnessconstructor.database.entities.WorkoutExercises


@Dao
interface CreateWorkoutDao {

    //create workout
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createWorkout(workout: WorkoutEntity)

    //editWorkout
    @Update
    suspend fun editWorkout(workout: WorkoutEntity)

    //addExerciseToWorkout
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun addExercise(exercise: WorkoutExercises)

    //removeExerciseFromWorkout
    @Delete
    fun deleteExercise(exercise: WorkoutExercises)

    //removeWorkoutEntity
    @Delete
    fun deleteWorkout(workout: WorkoutEntity)

    //cleanUpAllWorkouts
    @Query("DELETE FROM workout")
    fun deleteAllWorkouts()

}

