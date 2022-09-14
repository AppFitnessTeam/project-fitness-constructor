package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = WorkoutExercises.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = WorkoutEntity::class,
            parentColumns = [WorkoutEntity.COLUMN_ID],
            childColumns = [WorkoutExercises.COLUMN_WORKOUT_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AllExercisesEntity::class,
            parentColumns = [AllExercisesEntity.COLUMN_ID],
            childColumns = [WorkoutExercises.COLUMN_EXERCISE_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class WorkoutExercises(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int = 0,

    @ColumnInfo(name = COLUMN_WORKOUT_ID) // номер программы из списка программ тренировок
    val workoutId: Int,

    @ColumnInfo(name = COLUMN_DAY) // какой день тренировки. Всего 3 дня тренировки в неделю
    val day: String,

    @ColumnInfo(name = COLUMN_EXERCISE_ID) // номер упражнения из списка упражнений
    val exerciseId: Int,

    @ColumnInfo(name = COLUMN_COUNT) // количество , секунды или до отказа (-1)
    val count: Int,
) {
    companion object {
        const val TABLE_NAME = "workout_exercises"
        const val COLUMN_ID = "id"
        const val COLUMN_WORKOUT_ID = "workout_id"
        const val COLUMN_DAY = "day"
        const val COLUMN_EXERCISE_ID = "exercise_id"
        const val COLUMN_COUNT = "count"
    }
}
