package com.example.fitnessconstructor.ui.workoutlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fitnessconstructor.databinding.FragmentWorkoutListBinding
import com.example.fitnessconstructor.domain.entities.Workout
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutListFragment :
    BaseFragment<FragmentWorkoutListBinding>(FragmentWorkoutListBinding::inflate),
    ItemClickListener {

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
                toastBlock()
                //TODO("add create workout")
            }
        }
    }

    override fun onStartClick(workout: Workout) {
        val action =
            WorkoutListFragmentDirections.actionWorkoutListFragmentToWorkoutFragment(workout.id)
        findNavController().navigate(action)
    }

    override fun onSettingsClick(workout: Workout) {
        val action =
            WorkoutListFragmentDirections.actionWorkoutListFragmentToWorkoutSettingsFragment(workout.id)
        findNavController().navigate(action)
    }
}

interface ItemClickListener {
    fun onStartClick(workout: Workout)
    fun onSettingsClick(workout: Workout)
}