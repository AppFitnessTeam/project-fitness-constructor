package com.example.fitnessconstructor.ui.workoutlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.fitnessconstructor.domain.CreateWorkoutUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Workout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutListViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase,
    private val createWorkoutUseCase: CreateWorkoutUseCase
) : ViewModel() {

    val workoutList = workoutUseCase.getWorkoutsList().asLiveData()

    fun createWorkout(workout: Workout) {
        viewModelScope.launch {
            createWorkoutUseCase.createWorkout()
        }
    }
}