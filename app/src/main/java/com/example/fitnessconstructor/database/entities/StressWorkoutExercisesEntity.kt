package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = StressWorkoutExercisesEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = StressExercisesEntity::class,
            parentColumns = [StressExercisesEntity.COLUMN_ID],
            childColumns = [StressWorkoutExercisesEntity.COLUMN_STRESS_EXERCISES_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = WorkoutEntity::class,
            parentColumns = [WorkoutEntity.COLUMN_ID],
            childColumns = [StressWorkoutExercisesEntity.COLUMN_WORKOUT_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class StressWorkoutExercisesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int?,

    @ColumnInfo(name = COLUMN_WORKOUT_ID) // номер программы из списка программ тренировок
    val workoutId: Int?,     //здесь всегда будет 1

    @ColumnInfo(name = COLUMN_STRESS_EXERCISES_ID) // номер упражнения из списка упражнений
    val stressExercisesId: Int?,

    @ColumnInfo(name = COLUMN_COUNT)// количество секунд
    val count: Int?     //здесь всегда будет 1
) {
    companion object {
        const val TABLE_NAME = "stress_workout_exercises"
        const val COLUMN_ID = "id"
        const val COLUMN_WORKOUT_ID = "workout_id"
        const val COLUMN_STRESS_EXERCISES_ID = "stress_exercises_id"
        const val COLUMN_COUNT = "count"
    }
}