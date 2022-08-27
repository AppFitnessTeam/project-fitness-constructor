package com.example.fitnessconstructor.database

import androidx.room.Dao
import androidx.room.Query
import com.example.fitnessconstructor.database.entities.StressExercisesEntity
import com.example.fitnessconstructor.database.entities.StressWorkoutExercisesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StressDao {
    // получаем название стрессупражнения по его номеру, а таже его номер типа(всегда будет 1)
    @Query("SELECT * FROM stress_exercises WHERE id IS :id")
    fun getStressExercise(id: Int?): Flow<StressExercisesEntity>

    // получаем программу стресс теста
    @Query("SELECT * FROM stress_workout_exercises")
    fun getStressWorkoutExercises(): Flow<List<StressWorkoutExercisesEntity>>
}
