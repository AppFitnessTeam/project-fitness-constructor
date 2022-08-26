package com.example.fitnessconstructor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "groups")//таблица базы данных женщин и мужчин по возрастам
data class GroupEntity(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int?,

    @ColumnInfo(name = "age_and_sex") // колонка с именем группы
    val ageAndSex: String

) : Serializable
