package com.example.fitnessconstructor.database.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.fitnessconstructor.domain.entities.Exercise

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
        name = exercise.nameEng,
        type = getTypeExerciseById(exercise.typeId),
        count = workoutExercisesEntity.count,
        imagePath = exercise.imagePath
    )
}