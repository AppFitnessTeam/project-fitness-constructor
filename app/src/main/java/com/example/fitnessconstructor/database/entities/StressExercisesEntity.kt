package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.StepWorkout

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
    val id: Int,

    @ColumnInfo(name = COLUMN_NAME_ENG)
    val nameEng: String,

    @ColumnInfo(name = COLUMN_NAME_RUS)
    val nameRus: String,

    @ColumnInfo(name = COLUMN_TYPE_ID)
    val typeId: Int = 1,

    @ColumnInfo(name = COLUMN_COUNT)
    val count: Int = STRESS_COUNT
) {

    fun toStepWorkout(): StepWorkout {
        return Exercise(
            id = id,
            name = nameEng,
            type = getTypeExerciseById(typeId),
            count = count
        )
    }

    companion object {
        const val TABLE_NAME = "stress_exercises"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME_ENG = "name_eng"
        const val COLUMN_NAME_RUS = "name_rus"
        const val COLUMN_TYPE_ID = "type_id"
        const val COLUMN_COUNT = "count"

        private const val STRESS_COUNT = 30
    }
}