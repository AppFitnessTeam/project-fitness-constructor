package com.example.fitnessconstructor.ui.workoutsettings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.fitnessconstructor.domain.WorkoutSettingsUseCase
import com.example.fitnessconstructor.domain.entities.WorkoutSettings
import com.example.fitnessconstructor.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.sql.Time
import java.time.DayOfWeek
import javax.inject.Inject

@HiltViewModel
class WorkoutSettingsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val workoutSettingsUseCase: WorkoutSettingsUseCase
) : BaseViewModel() {

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
        workoutNewName: String,
        setsRest: Int,
        exerciseRest: Int,
        weekList: List<Pair<DayOfWeek, Time?>>
    ) {
        val newWorkoutSettings = WorkoutSettings(
            workoutId = workoutId,
            workoutName = workoutSettings.value!!.workoutName,
            workoutUserName = workoutNewName,
            setsRest = setsRest,
            exerciseRest = exerciseRest,
            weekList = weekList
        )
        viewModelScope.launch {
            workoutSettingsUseCase.updateWorkoutSettings(newWorkoutSettings)
            navigateBack()
        }
    }

    fun deleteWorkout() {
        viewModelScope.launch {
            workoutSettingsUseCase.deleteWorkout(workoutId)
            navigateBack()
        }
    }

    fun editExercises() {
        navigate(
            WorkoutSettingsFragmentDirections.actionWorkoutSettingsFragmentToEditWorkoutFragment(
                workoutId
            )
        )
    }
}