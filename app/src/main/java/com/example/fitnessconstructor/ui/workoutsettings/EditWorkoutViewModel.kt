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

    lateinit var allExercisesList: List<Exercise>

    init {
        _day.value = 1
        getWorkoutExercises()
        getAllExercises()
    }

    fun previousDay(exercisesList: List<Exercise>) {
        _day.value?.let {
            updateExercisesByDay(day.value!!, exercisesList)
            if (it > 1) _day.value = it - 1
            getWorkoutExercises()
        }
    }

    fun nextDay(exercisesList: List<Exercise>) {
        _day.value?.let {
            updateExercisesByDay(day.value!!, exercisesList)
            _day.value = it + 1
            getWorkoutExercises()
        }
    }

    fun addExercise(exercise: Exercise) {
        createWorkoutUseCase.addExerciseToWorkout(workoutId, day.value!!, exercise)
        getWorkoutExercises()
    }

    private fun getWorkoutExercises() {
        viewModelScope.launch {
            _exerciseList.postValue(createWorkoutUseCase.getExercisesByDay(workoutId, day.value!!))
        }
    }

    private fun getAllExercises() {
        viewModelScope.launch {
            allExercisesList = createWorkoutUseCase.getAllExercises()
        }
    }

    private fun updateExercisesByDay(day: Int, exercises: List<Exercise>) {
        viewModelScope.launch {
            createWorkoutUseCase.updateExercisesByDay(day, exercises)
        }
    }

    fun saveWorkout(){
        viewModelScope.launch {
            createWorkoutUseCase.saveWorkout()
        }
    }
}