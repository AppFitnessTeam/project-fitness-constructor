package com.example.fitnessconstructor.database

import androidx.room.*
import com.example.fitnessconstructor.database.entities.WorkoutEntity
import com.example.fitnessconstructor.database.entities.WorkoutExercisesEntity


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
    suspend fun addExercise(exercise: WorkoutExercisesEntity)

    //removeExerciseFromWorkout
    @Delete
    fun deleteExercise(exercise: WorkoutExercisesEntity)

    //removeWorkoutEntity
    @Delete
    fun deleteWorkout(workout: WorkoutEntity)

    //cleanUpAllWorkouts
    @Query("DELETE FROM workout")
    fun deleteAllWorkouts()

}

