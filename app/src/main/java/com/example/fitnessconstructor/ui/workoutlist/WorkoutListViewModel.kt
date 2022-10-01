package com.example.fitnessconstructor.ui.workoutlist

import androidx.lifecycle.asLiveData
import com.example.fitnessconstructor.domain.WorkoutUseCase
import com.example.fitnessconstructor.domain.entities.Workout
import com.example.fitnessconstructor.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkoutListViewModel @Inject constructor(
    private val workoutUseCase: WorkoutUseCase
) : BaseViewModel() {

    val workoutList = workoutUseCase.getSelectedWorkoutsList().asLiveData()

    fun startWorkout(workout: Workout) {
        navigate(
            WorkoutListFragmentDirections.actionWorkoutListFragmentToWorkoutFragment(
                workoutId = workout.id,
                day = workout.day
            )
        )
    }

    fun openSettings(workout: Workout) {
        navigate(
            WorkoutListFragmentDirections.actionWorkoutListFragmentToWorkoutSettingsFragment(
                workout.id
            )
        )
    }

    fun addWorkout(){
        navigate(
            WorkoutListFragmentDirections.actionWorkoutListFragmentToAddWorkoutFragment()
        )
    }
}
