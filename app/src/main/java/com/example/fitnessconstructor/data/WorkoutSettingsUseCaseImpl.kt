package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.database.WorkoutSettingsDao
import com.example.fitnessconstructor.database.entities.WorkoutNotificationEntity
import com.example.fitnessconstructor.domain.WorkoutSettingsUseCase
import com.example.fitnessconstructor.domain.entities.WorkoutSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.DayOfWeek
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

    override suspend fun updateWorkoutSettings(workoutSettings: WorkoutSettings) =
        withContext(Dispatchers.IO) {
            with(workoutSettingsDao) {
                updateWorkoutName(
                    workoutId = workoutSettings.workoutId,
                    workoutUserName = workoutSettings.workoutUserName ?: workoutSettings.workoutName
                )
                updateWorkoutRest(
                    workoutId = workoutSettings.workoutId,
                    setsRest = workoutSettings.setsRest,
                    exerciseRest = workoutSettings.exerciseRest
                )
                updateNotification(convertDataToNotificationEntity(workoutSettings))
            }
        }

    override suspend fun deleteWorkout(workoutId: Int) =
        withContext(Dispatchers.IO) {
            workoutSettingsDao.deleteWorkoutFromList(workoutId)
            workoutSettingsDao.deleteCustomWorkout(workoutId)
        }

    private fun convertDataToNotificationEntity(workoutSettings: WorkoutSettings): WorkoutNotificationEntity {
        return WorkoutNotificationEntity(
            workoutId = workoutSettings.workoutId,
            sunday = workoutSettings.findPairByDay(DayOfWeek.SUNDAY),
            monday = workoutSettings.findPairByDay(DayOfWeek.MONDAY),
            tuesday = workoutSettings.findPairByDay(DayOfWeek.TUESDAY),
            wednesday = workoutSettings.findPairByDay(DayOfWeek.WEDNESDAY),
            thursday = workoutSettings.findPairByDay(DayOfWeek.THURSDAY),
            friday = workoutSettings.findPairByDay(DayOfWeek.FRIDAY),
            saturday = workoutSettings.findPairByDay(DayOfWeek.SATURDAY)
        )
    }

    private fun WorkoutSettings.findPairByDay(dayOfWeek: DayOfWeek): Long? {
        this.weekList.forEach {
            if (it.first == dayOfWeek) return it.second?.time
        }
        throw NoSuchElementException("error")
    }
}