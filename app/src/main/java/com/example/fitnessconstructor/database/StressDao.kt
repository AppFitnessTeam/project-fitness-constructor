package com.example.fitnessconstructor.database

import androidx.room.Dao
import androidx.room.Query
import com.example.fitnessconstructor.database.entities.StressExercisesEntity

@Dao
interface StressDao {
    @Query("SELECT * FROM stress_exercises")
    suspend fun getStressExercises(): List<StressExercisesEntity>
}
