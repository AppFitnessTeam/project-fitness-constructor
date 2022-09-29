package com.example.fitnessconstructor.ui.workoutlist

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.fitnessconstructor.domain.StressUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddWorkoutViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase,
    private val stressUseCase: StressUseCase,
    dataStore: DataStore<Preferences>
) : ViewModel() {

    val allWorkoutList = workoutUseCase.getAllWorkoutsList().asLiveData()
}
