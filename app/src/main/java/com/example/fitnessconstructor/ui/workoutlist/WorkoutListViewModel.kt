package com.example.fitnessconstructor.ui.workoutlist

import androidx.lifecycle.*
import com.example.fitnessconstructor.domain.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkoutListViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase
) : ViewModel() {

    val workoutList = workoutUseCase.getSelectedWorkoutsList().asLiveData()
}
