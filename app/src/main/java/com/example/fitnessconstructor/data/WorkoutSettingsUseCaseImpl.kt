package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.database.WorkoutSettingsDao
import com.example.fitnessconstructor.domain.WorkoutSettingsUseCase
import com.example.fitnessconstructor.domain.entities.WorkoutSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkoutSettingsUseCaseImpl @Inject constructor(
    private val workoutSettingsDao: WorkoutSettingsDao
) : WorkoutSettingsUseCase {

    override suspend fun getWorkoutSettings(workoutId: Int): WorkoutSettings =
        withContext(Dispatchers.IO) {
            return@withContext workoutSettingsDao.getWorkoutSettings(workoutId).toWorkoutSettings()
        }

    override suspend fun updateWorkoutSettings(workoutSettings: WorkoutSettings) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWorkout(workoutId: Int) {
        TODO("Not yet implemented")
    }
}