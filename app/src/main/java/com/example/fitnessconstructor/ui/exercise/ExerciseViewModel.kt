package com.example.fitnessconstructor.ui.exercise

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.fitnessconstructor.domain.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    //TODO("add timer")
    savedStateHandle: SavedStateHandle,
    private val workoutUseCase: WorkoutUseCase
) : ViewModel() {

    private val navArgs = ExerciseFragmentArgs.fromSavedStateHandle(savedStateHandle)
    private val workout = navArgs.workout
    //TODO("get exercise")
}