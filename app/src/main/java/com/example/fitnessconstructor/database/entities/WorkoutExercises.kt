package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


//при первоначальном запуске можно будет выбрать на более 3 дней в неделю!!
// хотябы на первое время...

@Entity(tableName = "workout_exercises")//программа тренировок
data class WorkoutExercises(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int = 0,

    @ColumnInfo(name = "workout_id") // номер программы из списка программ тренировок
    val workoutId: Int,

    @ColumnInfo(name = "day") // какой день тренировки. Всего 3 дня тренировки в неделю
    val day: String,

    @ColumnInfo(name = "exercise_id") // номер упражнения из списка упражнений
    val exerciseId: Int,

    @ColumnInfo(name = "count") // количество , секунды или до отказа (-1)
    val count: Int,

    ) : Serializable