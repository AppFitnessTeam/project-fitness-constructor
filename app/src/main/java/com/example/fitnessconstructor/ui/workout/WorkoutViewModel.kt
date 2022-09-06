package com.example.fitnessconstructor.ui.workout

import androidx.lifecycle.*
import com.example.fitnessconstructor.domain.CreateWorkoutUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.domain.entities.StepWorkout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val createWorkoutUseCase: CreateWorkoutUseCase,
    private val workoutUseCase: WorkoutUseCase
) : ViewModel() {

    private val navArgs = WorkoutFragmentArgs.fromSavedStateHandle(savedStateHandle)
    private val workoutId = navArgs.workoutId //TODO("get workout")

    private val _exerciseList = MutableLiveData<List<Exercise>>()
    val exerciseList: LiveData<List<Exercise>> = _exerciseList

    lateinit var stepsWorkout: Array<StepWorkout>

    init {
        viewModelScope.launch {
            _exerciseList.postValue(workoutUseCase.getWorkoutExercises(7, 2))
            stepsWorkout = workoutUseCase.getWorkoutSteps(7, 2).toTypedArray()
        }
    }
}