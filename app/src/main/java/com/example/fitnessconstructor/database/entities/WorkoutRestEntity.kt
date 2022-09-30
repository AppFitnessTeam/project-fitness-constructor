package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.fitnessconstructor.domain.entities.Rest

@Entity(
    tableName = WorkoutRestEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = WorkoutEntity::class,
            parentColumns = [WorkoutEntity.COLUMN_ID],
            childColumns = [WorkoutRestEntity.COLUMN_WORKOUT_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class WorkoutRestEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int = 0,

    @ColumnInfo(name = COLUMN_WORKOUT_ID)
    val workoutId: Int,

    @ColumnInfo(name = COLUMN_SETS_REST)
    val setsRest: Int = DEFAULT_SETS_REST,

    @ColumnInfo(name = COLUMN_EXERCISE_REST)
    val exerciseRest: Int = DEFAULT_EXERCISE_REST
) {

    fun toListRest(): List<Rest> {
        return listOf(
            Rest(id = this.id, count = setsRest),
            Rest(id = this.id, count = exerciseRest)
        )
    }

    companion object {
        const val TABLE_NAME = "workout_rest"
        const val COLUMN_ID = "id"
        const val COLUMN_WORKOUT_ID = "workout_id"
        const val COLUMN_SETS_REST = "sets_rest"
        const val COLUMN_EXERCISE_REST = "exercise_rest"

        private const val DEFAULT_SETS_REST = 30
        private const val DEFAULT_EXERCISE_REST = 120
    }
}