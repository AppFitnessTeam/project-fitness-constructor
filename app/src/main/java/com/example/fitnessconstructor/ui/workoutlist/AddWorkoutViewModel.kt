package com.example.fitnessconstructor.ui.workoutlist

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.fitnessconstructor.di.PreferencesKeys
import com.example.fitnessconstructor.domain.StressUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Workout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddWorkoutViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase,
    private val stressUseCase: StressUseCase,
    private val dataStore: DataStore<Preferences>
) : ViewModel() {

    val allWorkoutList = workoutUseCase.getAllWorkoutsList().asLiveData()

    val userLevel = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.userLevelKey] ?: "Do test"
    }.asLiveData()

    fun addWorkoutToList(workout: Workout) {
        viewModelScope.launch {
            workoutUseCase.addWorkoutToSelected(workout.id)
        }
    }
}



