package com.example.fitnessconstructor.database.entities

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.ExerciseType
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ExercisesEntity(
    @Embedded val workoutExercises: WorkoutExercises,
    @Relation(
        parentColumn = "exercise_id",
        entityColumn = "id",
    )

    val exercise: AllExercisesEntity
) : Parcelable {

    fun toExercise(): Exercise = Exercise(
        id = workoutExercises.id.toInt(),

        name = exercise.nameEng.toString(),
//        type = ExerciseType.STEP,
        type = when (exercise.typeId?.toInt()) {
            1 -> ExerciseType.STRESS
            2 -> ExerciseType.STEP
            else -> {
                ExerciseType.TIME
            }
        },
        count = workoutExercises.id.toInt()
    )
}