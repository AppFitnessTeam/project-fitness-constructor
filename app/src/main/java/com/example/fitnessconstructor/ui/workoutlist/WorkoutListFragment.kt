package com.example.fitnessconstructor.ui.workoutlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.FragmentWorkoutListBinding
import com.example.fitnessconstructor.domain.entities.Workout
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutListFragment :
    BaseFragment<FragmentWorkoutListBinding>(FragmentWorkoutListBinding::inflate),
    ItemCustomWorkoutClickListener {

    private val viewModel: WorkoutListViewModel by viewModels()
    private val adapter = WorkoutListAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.workoutList.observe(viewLifecycleOwner) { renderData(it) }
    }

    private fun renderData(list: List<Workout>) {
        adapter.setData(list)
    }

    private fun initViews() {
        binding.apply {
            recyclerWorkoutList.adapter = adapter
            floatingActionButton.setOnClickListener {
                findNavController().navigate(R.id.action_workoutListFragment_to_addWorkoutFragment)
            }
        }
    }

    override fun onStartClick(workout: Workout) {
        val action =
            WorkoutListFragmentDirections.actionWorkoutListFragmentToWorkoutFragment(
                workoutId = workout.id,
                day = workout.day ?: 1
            )
        findNavController().navigate(action)
    }

    override fun onSettingsClick(workout: Workout) {
        val action =
            WorkoutListFragmentDirections.actionWorkoutListFragmentToWorkoutSettingsFragment(workout.id)
        findNavController().navigate(action)
    }
}

interface ItemCustomWorkoutClickListener {
    fun onStartClick(workout: Workout)
    fun onSettingsClick(workout: Workout)
}