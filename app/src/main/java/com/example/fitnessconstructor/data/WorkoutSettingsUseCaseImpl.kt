package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.domain.WorkoutSettingsUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkoutSettingsUseCaseImpl @Inject constructor() : WorkoutSettingsUseCase {
    override suspend fun setName(workoutName: String) {
        TODO("Not yet implemented")
    }

    override suspend fun setApprRest(apprRest: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun setExerciseRest(exerciseRest: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWorkout(workoutId: Int) {
        TODO("Not yet implemented")
    }
}