package com.example.fitnessconstructor.ui.workoutlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.fitnessconstructor.domain.WorkoutSettingsUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkoutListViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase,
    private val workoutSettingsUseCase: WorkoutSettingsUseCase
) : ViewModel() {

    val workoutList = workoutUseCase.getWorkoutsList().asLiveData()
}
