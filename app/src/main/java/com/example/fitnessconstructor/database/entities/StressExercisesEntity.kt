package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = StressExercisesEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = TypeExercisesEntity::class,
            parentColumns = [TypeExercisesEntity.COLUMN_ID],
            childColumns = [StressExercisesEntity.COLUMN_TYPE_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class StressExercisesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int?,

    @ColumnInfo(name = COLUMN_NAME_ENG) // колонка с аглийским названием упражнения
    val nameEng: String?,

    @ColumnInfo(name = COLUMN_NAME_RUS) // колонка с русским названием упражнения
    val nameRus: String?,

    // колонка с типом упражнения( стресс, количественный или на время)
    @ColumnInfo(name = COLUMN_TYPE_ID)
    val typeId: Int     //здесь всегда будет 1
) {
    companion object {
        const val TABLE_NAME = "stress_exercises"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME_ENG = "name_eng"
        const val COLUMN_NAME_RUS = "name_rus"
        const val COLUMN_TYPE_ID = "type_id"
    }
}