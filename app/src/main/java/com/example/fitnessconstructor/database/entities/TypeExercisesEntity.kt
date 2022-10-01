package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TypeExercisesEntity.TABLE_NAME)
data class TypeExercisesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int,

    @ColumnInfo(name = COLUMN_TYPE)
    val type: String
) {
    companion object {
        const val TABLE_NAME = "type_exercises"
        const val COLUMN_ID = "id"
        const val COLUMN_TYPE = "type"
    }
}