package com.example.fitnessconstructor.ui.workout

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.FragmentWorkoutBinding
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.ui.BaseFragment
import com.example.fitnessconstructor.ui.exercise.ExerciseFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutFragment : BaseFragment<FragmentWorkoutBinding>(FragmentWorkoutBinding::inflate) {

    private val viewModel: WorkoutViewModel by viewModels()
    private val args: WorkoutFragmentArgs by navArgs()

    private val adapter = WorkoutAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.exerciseList.observe(viewLifecycleOwner) { renderData(it) }
    }

    private fun renderData(exerciseList: List<Exercise>) {
        adapter.setData(exerciseList)
    }

    private fun initViews() {
        binding.apply {
            recyclerWorkout.adapter = adapter
            floatingActionButton.setOnClickListener {
                val action = WorkoutFragmentDirections.actionWorkoutFragmentToExerciseFragment(viewModel.stepsWorkout)
                findNavController().navigate(action)
            }
        }
    }
}