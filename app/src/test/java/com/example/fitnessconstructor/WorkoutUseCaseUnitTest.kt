package com.example.fitnessconstructor

import com.example.fitnessconstructor.data.WorkoutUseCaseImpl
import com.example.fitnessconstructor.domain.Exercise
import com.example.fitnessconstructor.domain.ExerciseType
import com.example.fitnessconstructor.domain.Rest
import com.example.fitnessconstructor.domain.StepWorkout
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Test WorkoutUseCase getStepsWorkout(...) function
 */
class WorkoutUseCaseUnitTest {

    private val workoutUseCase = WorkoutUseCaseImpl()
    private lateinit var exercises: List<Exercise>
    private lateinit var rest: List<Rest>

    @Before
    fun setUp() {
        exercises = listOf(
            Exercise(1, "Warm up", ExerciseType.TIME, 180),
            Exercise(2, "Squats", ExerciseType.STEP, 12),
            Exercise(2, "Squats", ExerciseType.STEP, 10),
            Exercise(2, "Squats", ExerciseType.STEP, -1),
            Exercise(3, "Running in place", ExerciseType.TIME, 30),
            Exercise(3, "Running in place", ExerciseType.TIME, 30),
            Exercise(3, "Running in place", ExerciseType.TIME, 30)
        )
        rest = listOf(
            Rest(count = 30),
            Rest(count = 120)
        )
    }

    @Test
    fun checkCreateSteps_correctData() = runBlocking {
        val result: List<StepWorkout> = listOf(
            exercises[0],
            rest[1],
            exercises[1],
            rest[0],
            exercises[2],
            rest[0],
            exercises[3],
            rest[1],
            exercises[4],
            rest[0],
            exercises[5],
            rest[0],
            exercises[5]
        )
        Assert.assertEquals(result, workoutUseCase.createStepsWorkout(exercises, rest))
    }

    //TODO ("add test getStepsWorkout(...) with database")
}