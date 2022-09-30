package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = WorkoutExercisesEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = WorkoutEntity::class,
            parentColumns = [WorkoutEntity.COLUMN_ID],
            childColumns = [WorkoutExercisesEntity.COLUMN_WORKOUT_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AllExercisesEntity::class,
            parentColumns = [AllExercisesEntity.COLUMN_ID],
            childColumns = [WorkoutExercisesEntity.COLUMN_EXERCISE_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class WorkoutExercisesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int = 0,

    @ColumnInfo(name = COLUMN_WORKOUT_ID)
    val workoutId: Int,

    @ColumnInfo(name = COLUMN_DAY)
    val day: String,

    @ColumnInfo(name = COLUMN_EXERCISE_ID)
    val exerciseId: Int,

    @ColumnInfo(name = COLUMN_COUNT)
    val count: Int = DEFAULT_COUNT,
) {
    companion object {
        const val TABLE_NAME = "workout_exercises"
        const val COLUMN_ID = "id"
        const val COLUMN_WORKOUT_ID = "workout_id"
        const val COLUMN_DAY = "day"
        const val COLUMN_EXERCISE_ID = "exercise_id"
        const val COLUMN_COUNT = "count"

        private const val DEFAULT_COUNT = 0
    }
}
