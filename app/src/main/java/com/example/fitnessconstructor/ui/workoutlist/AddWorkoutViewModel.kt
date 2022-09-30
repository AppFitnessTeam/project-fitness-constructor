package com.example.fitnessconstructor.ui.workoutlist

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.*
import com.example.fitnessconstructor.di.PreferencesKeys
import com.example.fitnessconstructor.domain.CreateWorkoutUseCase
import com.example.fitnessconstructor.domain.StressUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.domain.entities.Workout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddWorkoutViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase,
    private val stressUseCase: StressUseCase,
    private val createWorkoutUseCase: CreateWorkoutUseCase,
    private val dataStore: DataStore<Preferences>
) : ViewModel() {

    val allWorkoutList = workoutUseCase.getAllWorkoutsList().asLiveData()

    private val _stressStepsWorkout = MutableLiveData<Array<StepWorkout>>()
    val stressStepWorkout: LiveData<Array<StepWorkout>> = _stressStepsWorkout

    private val _newWorkoutId = MutableLiveData<Int>()
    val newWorkoutId: LiveData<Int> = _newWorkoutId

    val userLevel = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.userLevelKey] ?: "Do test"
    }.asLiveData()

    fun addWorkoutToList(workout: Workout) {
        viewModelScope.launch {
            workoutUseCase.addWorkoutToSelected(workout.id)
        }
    }

    fun getStressWorkoutSteps() {
        viewModelScope.launch {
            _stressStepsWorkout.postValue(stressUseCase.getWorkoutSteps().toTypedArray())
        }
    }

    fun createWorkout() {
        viewModelScope.launch {
            val newWorkout = Workout(
                name = "New workout"
            )
            createWorkoutUseCase.createWorkout(newWorkout)
            _newWorkoutId.postValue(newWorkout.id)
        }
    }
}



