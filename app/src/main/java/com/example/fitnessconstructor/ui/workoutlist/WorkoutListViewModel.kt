package com.example.fitnessconstructor.ui.workoutlist

import androidx.lifecycle.*
import com.example.fitnessconstructor.domain.WorkoutSettingsUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.WorkoutSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.sql.Time
import java.time.DayOfWeek
import javax.inject.Inject

@HiltViewModel
class WorkoutListViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase,
    private val workoutSettingsUseCase: WorkoutSettingsUseCase
) : ViewModel() {

    val workoutList = workoutUseCase.getWorkoutsList().asLiveData()

    private val _workoutSettings = MutableLiveData<WorkoutSettings>()
    val workoutSettings: LiveData<WorkoutSettings> = _workoutSettings

    fun getWorkoutSettings() {
        viewModelScope.launch {
            _workoutSettings.postValue(workoutSettingsUseCase.getWorkoutSettings())
        }
    }

    fun updateWorkoutSettings(
        workoutId: Int,
        workoutName: String,
        setsRest: Int,
        exerciseRest: Int,
        timeArray: Array<Time?>
    ) {
        val newWorkoutSettings = WorkoutSettings(
            workoutId = workoutId,
            workoutName = workoutName,
            workoutUserName = workoutName,
            setsRest = setsRest,
            exerciseRest = exerciseRest,
            weekList = listOf(
                DayOfWeek.SUNDAY to timeArray[0],
                DayOfWeek.MONDAY to timeArray[1],
                DayOfWeek.TUESDAY to timeArray[2],
                DayOfWeek.WEDNESDAY to timeArray[3],
                DayOfWeek.THURSDAY to timeArray[4],
                DayOfWeek.FRIDAY to timeArray[5],
                DayOfWeek.SATURDAY to timeArray[6]
            )
        )
        viewModelScope.launch {
            workoutSettingsUseCase.updateWorkoutSettings(newWorkoutSettings)
        }
    }
}
