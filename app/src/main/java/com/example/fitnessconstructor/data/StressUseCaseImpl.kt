package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.domain.StepWorkout
import com.example.fitnessconstructor.domain.StressUseCase
import com.example.fitnessconstructor.domain.Workout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StressUseCaseImpl @Inject constructor() : StressUseCase {

    @Inject
    lateinit var repository: FakeRepository //TODO ("change when working with real database")

    override suspend fun getStressWorkout(): Workout =
        withContext(Dispatchers.IO) {
            return@withContext repository.getStressWorkout()
        }

    override fun getStressExercises(): Flow<StepWorkout> {
        return repository.getStressWorkout().stepsWorkout.asFlow().flowOn(Dispatchers.IO)
    }

    override suspend fun getResult(stressTestResult: Array<Int>): String {
        return checkResult(stressTestResult)
    }

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