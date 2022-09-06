package com.example.fitnessconstructor.ui.workout

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.fitnessconstructor.domain.CreateWorkoutUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val createWorkoutUseCase: CreateWorkoutUseCase,
    private val workoutUseCase: WorkoutUseCase
) : ViewModel() {

    private val navArgs = WorkoutFragmentArgs.fromSavedStateHandle(savedStateHandle)
    private val workoutId = navArgs.workoutId //TODO("get workout")
//    val workoutExercises = workoutUseCase.getExercisesWorkout(//TODO("workout")).asLiveData()

}