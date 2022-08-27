package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "stress_exercises")//таблица базы данных названия упражнений стресс теста
data class StressExercisesEntity(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int?,

    @ColumnInfo(name = "name_eng") // колонка с аглийским названием упражнения
    val nameEng: String?,

    @ColumnInfo(name = "name_rus") // колонка с русским названием упражнения
    val nameRus: String?,

    // колонка с типом упражнения( стресс, количественный или на время)
    @ColumnInfo(name = "type_id")
    val typeId: Int?     //здесь всегда будет 1

) : Serializable