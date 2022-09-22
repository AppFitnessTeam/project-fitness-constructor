package com.example.fitnessconstructor.ui.workoutlist

import androidx.lifecycle.*
import com.example.fitnessconstructor.domain.WorkoutSettingsUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.WorkoutSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.sql.Time
import java.time.DayOfWeek
import javax.inject.Inject

@HiltViewModel
class WorkoutListViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase
) : ViewModel() {

    val workoutList = workoutUseCase.getWorkoutsList().asLiveData()
}
