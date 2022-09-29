package com.example.fitnessconstructor.domain

import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.domain.entities.Workout
import kotlinx.coroutines.flow.Flow

interface StressUseCase {
    suspend fun getWorkoutSteps(): List<StepWorkout>
    suspend fun getResult(stressTestResult: Array<Int>): String
}