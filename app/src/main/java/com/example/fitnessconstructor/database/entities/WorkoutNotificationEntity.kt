package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = WorkoutNotificationEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = WorkoutEntity::class,
            parentColumns = [WorkoutEntity.COLUMN_ID],
            childColumns = [WorkoutNotificationEntity.COLUMN_WORKOUT_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class WorkoutNotificationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int = 0,

    @ColumnInfo(name = COLUMN_WORKOUT_ID) // номер программы из списка программ тренировок
    val workoutId: Int?,

    @ColumnInfo(name = COLUMN_MO) //время в понедельник
    val monday: Long?,
    @ColumnInfo(name = COLUMN_TU)
    val tuesday: Long?,
    @ColumnInfo(name = COLUMN_WE)
    val wednesday: Long?,
    @ColumnInfo(name = COLUMN_TH)
    val thursday: Long?,
    @ColumnInfo(name = COLUMN_FR)
    val friday: Long?,
    @ColumnInfo(name = COLUMN_SA)
    val saturday: Long?,
    @ColumnInfo(name = COLUMN_SU)
    val sunday: Long?,
) {

    companion object {
        const val TABLE_NAME = "workout_notification"
        const val COLUMN_ID = "id"
        const val COLUMN_WORKOUT_ID = "workout_id"
        const val COLUMN_MO = "monday"
        const val COLUMN_TU = "tuesday"
        const val COLUMN_WE = "wedensday"
        const val COLUMN_TH = "thursday"
        const val COLUMN_FR = "friday"
        const val COLUMN_SA = "saturday"
        const val COLUMN_SU = "sunday"
    }
}