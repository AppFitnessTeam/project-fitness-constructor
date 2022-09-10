package com.example.fitnessconstructor

import com.example.fitnessconstructor.data.WorkoutUseCaseImpl
import com.example.fitnessconstructor.database.WorkoutDao
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.ExerciseType
import com.example.fitnessconstructor.domain.entities.Rest
import com.example.fitnessconstructor.domain.entities.StepWorkout
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Test WorkoutUseCase getStepsWorkout(...) function
 */
class WorkoutUseCaseUnitTest {

    @Mock
    private lateinit var workoutDao: WorkoutDao
    private lateinit var workoutUseCase: WorkoutUseCaseImpl
    private lateinit var exercises: List<Exercise>
    private lateinit var rest: List<Rest>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        workoutUseCase = WorkoutUseCaseImpl(workoutDao)
        exercises = listOf(
            Exercise(1, "Warm up", ExerciseType.TIME, 180),
            Exercise(2, "Squats", ExerciseType.STEP, 12),
            Exercise(3, "Squats", ExerciseType.STEP, 10),
            Exercise(4, "Squats", ExerciseType.STEP, -1),
            Exercise(5, "Running in place", ExerciseType.TIME, 30),
            Exercise(6, "Running in place", ExerciseType.TIME, 30),
            Exercise(7, "Running in place", ExerciseType.TIME, 30)
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
            exercises[6]
        )
        Assert.assertEquals(result, workoutUseCase.createStepsWorkout(exercises, rest))
    }

    //TODO ("add test getStepsWorkout(...) with database")
}