package com.example.fitnessconstructor.database.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.fitnessconstructor.domain.entities.WorkoutSettings

data class WorkoutSettingsEntity(
    @Embedded val workout: WorkoutEntity,
    @Relation(
        parentColumn = WorkoutEntity.COLUMN_ID,
        entityColumn = WorkoutRestEntity.COLUMN_WORKOUT_ID,
    )
    val rest: WorkoutRestEntity
) {

    fun toWorkoutSettings(): WorkoutSettings = WorkoutSettings(
        workoutId = workout.id,
        workoutName = workout.name,
        apprRest = rest.apprRest,
        exerciseRest = rest.exerciseRest,
        workoutUserName = workout.userName
        // week = null //TODO не пойму что сдесь получать???
    )
}