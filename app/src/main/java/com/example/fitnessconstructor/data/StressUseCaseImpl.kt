package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.database.StressDao
import com.example.fitnessconstructor.domain.StressUseCase
import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.domain.entities.Workout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StressUseCaseImpl @Inject constructor(
    private val stressDao: StressDao
) : StressUseCase {

    override suspend fun getStressWorkout(): Workout {
        TODO("later")
    }

    override fun getStressExercises(): Flow<StepWorkout> {
        TODO("later")
    }

    override suspend fun getResult(stressTestResult: Array<Int>): String =
        withContext(Dispatchers.Default) {
            return@withContext checkResult(stressTestResult)
        }

    /**
     * This fun is checking user's stress test results
     * @param stressTestResult Array<Int> of 3 elements
     * @return text message of user's power
     * @throws IllegalArgumentException when sum of array's elements is more than 300
     */
    private fun checkResult(stressTestResult: Array<Int>): String {
        return when (stressTestResult.sum()) {
            in StressResult.LOW.intRange -> StressResult.LOW.message
            in StressResult.NORMAL.intRange -> StressResult.NORMAL.message
            in StressResult.HIGH.intRange -> StressResult.HIGH.message
            in StressResult.MONSTER.intRange -> StressResult.MONSTER.message
            else -> {
                throw IllegalArgumentException("Are you kidding?")
            }
        }
    }

    private enum class StressResult(val intRange: IntRange, val message: String) {
        LOW(0..80, "Your POWER is below average. We will help you"),
        NORMAL(81..100, "Good POWER"),
        HIGH(101..150, "High POWER"),
        MONSTER(151..300, "Excellent POWER"),
    }
}