package com.example.fitnessconstructor.database

import androidx.room.Dao
import androidx.room.Query
import com.example.fitnessconstructor.database.entities.WorkoutSettingsEntity

@Dao
interface WorkoutSettingsDao {

    @Query("SELECT * FROM workout  WHERE id IS :id")
    suspend fun getWorkoutSettings(id: Int?): WorkoutSettingsEntity
}