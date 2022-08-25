package com.example.fitnessconstructor.domain

data class Workout(
    val id: Int,
    val name: String,
    val stepsWorkout: List<StepWorkout>
)

abstract class StepWorkout {
    abstract val name: String
    abstract val count: Int
}

/**
 * Class for exercises
 * @param type STEP or TIME
 * @param count for amount or time of exercises
 */
data class Exercise(
    val id: Int,
    override val name: String,
    val type: ExerciseType,
    override val count: Int
) : StepWorkout()

enum class ExerciseType {
    STEP, TIME
}

/**
 * Class for rest timer between exercises
 */
data class Rest(
    val id: Int,
    override val name: String = "Rest time",
    override val count: Int
) : StepWorkout()
