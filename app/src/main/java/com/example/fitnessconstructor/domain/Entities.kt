package com.example.fitnessconstructor.domain

data class Workout(
    val id: Int,
    val name: String,
    val stepsWorkout: MutableList<StepWorkout>
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
    override var count: Int = 0 //TODO("change var to val when working with real database")
) : StepWorkout()

enum class ExerciseType {
    STEP, TIME, STRESS
}

/**
 * Class for rest timer between exercises
 */
data class Rest(
    val id: Int = 0,
    override val name: String = "Rest time",
    override val count: Int = 0
) : StepWorkout()
