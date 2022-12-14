package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.ExerciseType

@Entity(
    tableName = AllExercisesEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = TypeExercisesEntity::class,
            parentColumns = [TypeExercisesEntity.COLUMN_ID],
            childColumns = [AllExercisesEntity.COLUMN_TYPE_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class AllExercisesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int,

    @ColumnInfo(name = COLUMN_NAME_ENG)
    val nameEng: String,

    @ColumnInfo(name = COLUMN_NAME_RUS)
    val nameRus: String,

    @ColumnInfo(name = COLUMN_TYPE_ID)
    val typeId: Int,

    @ColumnInfo(name = COLUMN_IMAGE_PATH)
    val imagePath: String
) {

    fun toExercise(): Exercise {
        return Exercise(
            id = id,
            name = nameEng,
            type = when (typeId) {
                1 -> ExerciseType.STRESS
                2 -> ExerciseType.STEP
                else -> {
                    ExerciseType.TIME
                }
            },
            count = 0
        )
    }

    companion object {
        const val TABLE_NAME = "all_exercises"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME_ENG = "name_eng"
        const val COLUMN_NAME_RUS = "name_rus"
        const val COLUMN_TYPE_ID = "type_id"
        const val COLUMN_IMAGE_PATH = "image_path"
    }
}