package com.example.fitnessconstructor.ui.workoutlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.fitnessconstructor.databinding.FragmentWorkoutListBinding
import com.example.fitnessconstructor.domain.entities.Workout
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutListFragment :
    BaseFragment<FragmentWorkoutListBinding, WorkoutListViewModel>(
        FragmentWorkoutListBinding::inflate
    ), ItemCustomWorkoutClickListener {

    override val viewModel: WorkoutListViewModel by viewModels()

    private val adapter = WorkoutListAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeNavigation()
        viewModel.workoutList.observe(viewLifecycleOwner) { renderData(it) }
    }

    private fun renderData(list: List<Workout>) {
        adapter.setData(list)
    }

    private fun initViews() {
        binding.apply {
            recyclerWorkoutList.adapter = adapter
            floatingActionButton.setOnClickListener { viewModel.addWorkout() }
        }
    }

    override fun onStartClick(workout: Workout) {
        viewModel.startWorkout(workout)
    }

    override fun onSettingsClick(workout: Workout) {
        viewModel.openSettings(workout)
    }
}

interface ItemCustomWorkoutClickListener {
    fun onStartClick(workout: Workout)
    fun onSettingsClick(workout: Workout)
}