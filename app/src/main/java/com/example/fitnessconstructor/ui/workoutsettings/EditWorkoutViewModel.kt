package com.example.fitnessconstructor.ui.workoutsettings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.fitnessconstructor.domain.CreateWorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditWorkoutViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val createWorkoutUseCase: CreateWorkoutUseCase
) : BaseViewModel() {

    private val navArgs = EditWorkoutFragmentArgs.fromSavedStateHandle(savedStateHandle)
    private val workoutId = navArgs.workoutId

    private val _day = MutableLiveData<Int>().apply {
        value = 1
    }
    val day: LiveData<Int> = _day

    private val _exerciseList = MutableLiveData<List<Exercise>>()
    val exerciseList: LiveData<List<Exercise>> = _exerciseList

    init {
        _day.value = 1
        getWorkoutExercises()
    }

    fun getWorkoutExercises() {
        viewModelScope.launch {
            _exerciseList.postValue(createWorkoutUseCase.getExercisesByDay(workoutId, day.value!!))
        }
    }

    fun previousDay() {
        _day.value?.let {
            if (it > 1) _day.value = it - 1
            getWorkoutExercises()
        }
    }

    fun nextDay() {
        _day.value?.let {
            _day.value = it + 1
            getWorkoutExercises()
        }
    }
}