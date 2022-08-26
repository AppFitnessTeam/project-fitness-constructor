package com.example.fitnessconstructor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "tabl_exercise")//таблица базы данных названия упражнений
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int?,

    @ColumnInfo(name = "exercise_eng") // колонка с аглийским названием упражнения
    val exerciseEng: String,

    @ColumnInfo(name = "exercise_rus") // колонка с русским названием упражнения
    val exerciseRus: String

) : Serializable