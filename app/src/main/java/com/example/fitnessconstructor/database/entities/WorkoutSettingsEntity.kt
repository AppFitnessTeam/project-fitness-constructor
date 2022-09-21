package com.example.fitnessconstructor.database.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.fitnessconstructor.domain.entities.WorkoutSettings
import java.sql.Time
import java.time.DayOfWeek

data class WorkoutSettingsEntity(
    @Embedded val workout: WorkoutEntity,
    @Relation(
        parentColumn = WorkoutEntity.COLUMN_ID,
        entityColumn = WorkoutRestEntity.COLUMN_WORKOUT_ID,
    )
    val rest: WorkoutRestEntity,
    @Relation(
        parentColumn = WorkoutEntity.COLUMN_ID,
        entityColumn = WorkoutNotificationEntity.COLUMN_WORKOUT_ID
    )
    val notification: WorkoutNotificationEntity
) {

    fun toWorkoutSettings(): WorkoutSettings = WorkoutSettings(
        workoutId = workout.id,
        workoutName = workout.name,
        setsRest = rest.setsRest,
        exerciseRest = rest.exerciseRest,
        workoutUserName = workout.userName,
        weekList = listOf<Pair<DayOfWeek,Time?>>(
            DayOfWeek.SUNDAY to notification.sunday?.let { Time(it) },
            DayOfWeek.MONDAY to notification.monday?.let { Time(it) },
            DayOfWeek.TUESDAY to notification.tuesday?.let { Time(it) },
            DayOfWeek.WEDNESDAY to notification.wednesday?.let { Time(it) },
            DayOfWeek.THURSDAY to notification.thursday?.let { Time(it) },
            DayOfWeek.FRIDAY to notification.friday?.let { Time(it) },
            DayOfWeek.SATURDAY to notification.saturday?.let { Time(it) }
        )
    )
}