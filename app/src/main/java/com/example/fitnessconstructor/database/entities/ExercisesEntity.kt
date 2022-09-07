package com.example.fitnessconstructor.database.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.ExerciseType

data class ExercisesEntity(
    @Embedded val workoutExercises: WorkoutExercises,
    @Relation(
        parentColumn = "exercise_id",
        entityColumn = "id",
    )

    val exercise: AllExercisesEntity
) {

    fun toExercise(): Exercise = Exercise(
        id = workoutExercises.id,
        name = exercise.nameEng.toString(),
        type = when (exercise.typeId?.toInt()) {
            1 -> ExerciseType.STRESS
            2 -> ExerciseType.STEP
            else -> {
                ExerciseType.TIME
            }
        },
        count = workoutExercises.count
    )
}