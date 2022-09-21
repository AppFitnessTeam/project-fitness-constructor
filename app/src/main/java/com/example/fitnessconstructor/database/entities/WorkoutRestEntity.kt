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

    @ColumnInfo(name = COLUMN_WORKOUT_ID) // номер программы из списка программ тренировок
    val workoutId: Int?,     //здесь всегда будет 1

    @ColumnInfo(name = COLUMN_SETS_REST) // время отдыха между подходами в упражнении
    val setsRest: Int,

    @ColumnInfo(name = COLUMN_EXERCISE_REST)// время отдыха между упражнениями
    val exerciseRest: Int
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
        const val COLUMN_SETS_REST = "appr_rest"
        const val COLUMN_EXERCISE_REST = "exercise_rest"
    }
}