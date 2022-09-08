package com.example.fitnessconstructor.ui.exercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.fitnessconstructor.domain.entities.StepWorkout
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val navArgs = ExerciseFragmentArgs.fromSavedStateHandle(savedStateHandle)
    private val stepsWorkout = navArgs.stepsWorkout
    private val iteratorSteps = stepsWorkout.iterator()

    private val _stepWorkout = MutableLiveData<StepWorkout>()
    val stepWorkout: LiveData<StepWorkout> = _stepWorkout

    private val _isSteps = MutableLiveData<Boolean>()
    val isSteps: LiveData<Boolean> = _isSteps

    init {
        nextStep()
    }

    fun nextStep() {
        if (iteratorSteps.hasNext()) {
            _stepWorkout.postValue(iteratorSteps.next())
        } else {
            _isSteps.postValue(false)
        }
    }
}