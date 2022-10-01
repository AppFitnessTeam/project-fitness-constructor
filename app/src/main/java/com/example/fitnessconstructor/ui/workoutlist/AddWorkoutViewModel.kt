package com.example.fitnessconstructor.ui.workoutlist

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.fitnessconstructor.di.PreferencesKeys
import com.example.fitnessconstructor.domain.CreateWorkoutUseCase
import com.example.fitnessconstructor.domain.StressUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Workout
import com.example.fitnessconstructor.ui.BaseViewModel
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
) : BaseViewModel() {

    val allWorkoutList = workoutUseCase.getAllWorkoutsList().asLiveData()

    val userLevel = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.userLevelKey] ?: "Do test"
    }.asLiveData()

    fun startStressTest() {
        viewModelScope.launch {
            navigate(
                AddWorkoutFragmentDirections.actionAddWorkoutFragmentToExerciseFragment(
                    stressUseCase.getWorkoutSteps().toTypedArray()
                )
            )
        }
    }

    fun createWorkout() {
        viewModelScope.launch {
            val newWorkout = Workout(
                name = "New workout"
            )
            createWorkoutUseCase.createWorkout(newWorkout)

            navigate(
                AddWorkoutFragmentDirections.actionAddWorkoutFragmentToWorkoutSettingsFragment(
                    createWorkoutUseCase.getLastWorkoutId()
                )
            )
        }
    }

    fun addPreloadWorkout(workoutId: Int) {
        viewModelScope.launch {
            workoutUseCase.addWorkoutToSelected(workoutId)
        }

        navigate(
            AddWorkoutFragmentDirections.actionAddWorkoutFragmentToWorkoutSettingsFragment(workoutId)
        )
    }
}



