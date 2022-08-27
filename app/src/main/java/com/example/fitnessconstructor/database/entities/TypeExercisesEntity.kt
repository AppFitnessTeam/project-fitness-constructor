package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "type_exercises")//таблица с типом упражнения( стресс, количественный или на время)
data class TypeExercisesEntity(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int?,

    @ColumnInfo(name = "type") // колонка с типом упражнения( стресс, количественный или на время)
    val type: String?

) : Serializable