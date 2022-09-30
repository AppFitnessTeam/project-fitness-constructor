package com.example.fitnessconstructor.ui.workoutsettings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fitnessconstructor.databinding.FragmentWorkoutSettingsBinding
import com.example.fitnessconstructor.domain.entities.WorkoutSettings
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutSettingsFragment :
    BaseFragment<FragmentWorkoutSettingsBinding>(FragmentWorkoutSettingsBinding::inflate),
    SetTimeByWeek {

    private val viewModel: WorkoutSettingsViewModel by viewModels()
    private val args: WorkoutSettingsFragmentArgs by navArgs()
    private val adapter = WeekListAdapter(this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.workoutSettings.observe(viewLifecycleOwner) { renderData(it) }
        viewModel.getWorkoutSettings()
    }

    private fun renderData(workoutSettings: WorkoutSettings) {
        with(binding) {
            workoutNameEditText.setText(workoutSettings.workoutUserName)
            setsTimeSlider.value = workoutSettings.setsRest.toFloat()
            exerciseTimeSlider.value = workoutSettings.exerciseRest.toFloat()
        }
        adapter.setWeekList(workoutSettings.weekList)
    }

    private fun initViews() {
        with(binding) {
            weekNotificationRecyclerView.adapter = adapter
            saveButton.setOnClickListener { updateSettings() }
            deleteButton.setOnClickListener { deleteWorkout() }
            editExercisesButton.setOnClickListener { editExercises(args.workoutId) }
            setsTimeSlider.value = 30f
            exerciseTimeSlider.value = 120f
        }
    }

    private fun editExercises(workoutId: Int) {
        val action =
            WorkoutSettingsFragmentDirections.actionWorkoutSettingsFragmentToEditWorkoutFragment(
                workoutId
            )
        findNavController().navigate(action)
    }

    private fun deleteWorkout() {
        viewModel.deleteWorkout()
        findNavController().navigateUp()
    }

    private fun updateSettings() {
        viewModel.updateWorkoutSettings(
            workoutName = binding.workoutNameEditText.text.toString(),
            setsRest = binding.setsTimeSlider.value.toInt(),
            exerciseRest = binding.exerciseTimeSlider.value.toInt(),
            weekList = adapter.getWeekList()
        )
        findNavController().navigateUp()
    }

    override fun onSetTimeClick() {
        toastBlock()
    }
}

interface SetTimeByWeek {
    fun onSetTimeClick()
}