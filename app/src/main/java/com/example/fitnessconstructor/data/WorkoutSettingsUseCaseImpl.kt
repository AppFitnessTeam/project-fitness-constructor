package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.domain.WorkoutSettingsUseCase
import com.example.fitnessconstructor.domain.entities.WorkoutSettings
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkoutSettingsUseCaseImpl @Inject constructor(
    //TODO("add dao")
) : WorkoutSettingsUseCase {
    override suspend fun getWorkoutSettings(): WorkoutSettings {
        TODO("Not yet implemented")
    }

    override suspend fun updateWorkoutSettings(workoutSettings: WorkoutSettings) {
        TODO("Not yet implemented")
    }
}