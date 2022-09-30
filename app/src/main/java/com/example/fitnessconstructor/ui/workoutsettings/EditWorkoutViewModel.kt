package com.example.fitnessconstructor.ui.workoutsettings

import androidx.lifecycle.*
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

    lateinit var exerciseList: LiveData<List<Exercise>>

    init {
        viewModelScope.launch {
            getWorkoutExercises(workoutId, 1)
        }
    }

    fun getWorkoutExercises(workoutId: Int, day: Int) {
        viewModelScope.launch {
            exerciseList = createWorkoutUseCase.getWorkoutExercises(workoutId, day).asLiveData()
        }
    }
}