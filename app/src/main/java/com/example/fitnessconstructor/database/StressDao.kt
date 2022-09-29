package com.example.fitnessconstructor.database

import androidx.room.Dao
import androidx.room.Query
import com.example.fitnessconstructor.database.entities.StressExercisesEntity
import com.example.fitnessconstructor.database.entities.StressWorkoutExercisesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StressDao {
    @Query("SELECT * FROM stress_exercises")
    suspend fun getStressExercises(): List<StressExercisesEntity>
}
