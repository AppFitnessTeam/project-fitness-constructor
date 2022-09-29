package com.example.fitnessconstructor.domain

import com.example.fitnessconstructor.domain.entities.StepWorkout

interface StressUseCase {
    suspend fun getWorkoutSteps(): List<StepWorkout>
    suspend fun getResult(stressTestResult: Array<Int>): String
}