package com.example.fitnessconstructor.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.fitnessconstructor.database.entities.WorkoutNotificationEntity
import com.example.fitnessconstructor.database.entities.WorkoutSettingsEntity

@Dao
interface WorkoutSettingsDao {

    @Query("SELECT * FROM workout  WHERE id IS :id")
    suspend fun getWorkoutSettings(id: Int?): WorkoutSettingsEntity

    @Query("UPDATE workout SET user_name = :workoutUserName WHERE id IS :workoutId")
    suspend fun updateWorkoutName(workoutId: Int, workoutUserName: String)

    @Query("UPDATE workout_rest SET appr_rest =:setsRest AND exercise_rest = :exerciseRest  WHERE id = :workoutId")
    suspend fun updateWorkoutRest(workoutId: Int, setsRest: Int, exerciseRest: Int)

    @Update
    suspend fun updateNotification(workoutNotificationEntity: WorkoutNotificationEntity)

    @Query("DELETE FROM workout WHERE id IS :id")
    suspend fun deleteWorkout(id: Int?)
}