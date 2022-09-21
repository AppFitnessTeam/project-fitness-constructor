package com.example.fitnessconstructor.database.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.ExerciseType

data class ExercisesEntity(
    @Embedded val workoutExercisesEntity: WorkoutExercisesEntity,
    @Relation(
        parentColumn = WorkoutExercisesEntity.COLUMN_EXERCISE_ID,
        entityColumn = AllExercisesEntity.COLUMN_ID,
    )
    val exercise: AllExercisesEntity
) {

    fun toExercise(): Exercise = Exercise(
        id = workoutExercisesEntity.id,
        name = exercise.nameEng.toString(),
        type = when (exercise.typeId?.toInt()) {
            1 -> ExerciseType.STRESS
            2 -> ExerciseType.STEP
            else -> {
                ExerciseType.TIME
            }
        },
        count = workoutExercisesEntity.count
    )
}