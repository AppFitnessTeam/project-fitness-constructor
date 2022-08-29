package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "stress_workout_exercises")//программа стресс теста
data class StressWorkoutExercisesEntity(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int?,

    @ColumnInfo(name = "workout_id") // номер программы из списка программ тренировок
    val workoutId: Int?,     //здесь всегда будет 1

    @ColumnInfo(name = "stress_exercises_id") // номер упражнения из списка упражнений
    val stressExercisesId: Int?,

    @ColumnInfo(name = "count")// количество секунд
    val count: Int?     //здесь всегда будет 1

) : Serializable