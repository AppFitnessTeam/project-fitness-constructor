package com.example.fitnessconstructor.ui.workoutsettings

import androidx.lifecycle.*
import com.example.fitnessconstructor.domain.WorkoutSettingsUseCase
import com.example.fitnessconstructor.domain.entities.WorkoutSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.sql.Time
import java.time.DayOfWeek
import javax.inject.Inject

@HiltViewModel
class WorkoutSettingsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val workoutSettingsUseCase: WorkoutSettingsUseCase
) : ViewModel() {

    private val navArgs = WorkoutSettingsFragmentArgs.fromSavedStateHandle(savedStateHandle)
    private val workoutId = navArgs.workoutId

    private val _workoutSettings = MutableLiveData<WorkoutSettings>()
    val workoutSettings: LiveData<WorkoutSettings> = _workoutSettings

    fun getWorkoutSettings() {
        viewModelScope.launch {
            _workoutSettings.postValue(workoutSettingsUseCase.getWorkoutSettings(workoutId))
        }
    }

    fun updateWorkoutSettings(
        workoutName: String,
        setsRest: Int,
        exerciseRest: Int,
        weekList: List<Pair<DayOfWeek, Time?>>
    ) {
        val newWorkoutSettings = WorkoutSettings(
            workoutId = workoutId,
            workoutName = workoutName,
            workoutUserName = workoutName,
            setsRest = setsRest,
            exerciseRest = exerciseRest,
            weekList = weekList
        )
        viewModelScope.launch {
            workoutSettingsUseCase.updateWorkoutSettings(newWorkoutSettings)
        }
    }

    fun deleteWorkout() {
        viewModelScope.launch {
            workoutSettingsUseCase.deleteWorkout(workoutId)
        }
    }
}