package com.example.fitnessconstructor.ui.exercise

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fitnessconstructor.databinding.FragmentExerciseBinding
import com.example.fitnessconstructor.domain.entities.ExerciseType
import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseFragment : BaseFragment<FragmentExerciseBinding>(FragmentExerciseBinding::inflate) {

    private val viewModel: ExerciseViewModel by viewModels()
    private val navArgs: ExerciseFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.stepWorkout.observe(viewLifecycleOwner) { renderData(it) }
    }

    private fun initView() {
        with(binding) {
            buttonNext.setOnClickListener { viewModel.nextStep() }
            buttonSkip.setOnClickListener { findNavController().navigateUp() }
        }
    }

    private fun renderData(stepWorkout: StepWorkout) {
        when (stepWorkout.type) {
            ExerciseType.STEP -> setViewStep(stepWorkout)
            ExerciseType.TIME -> setViewTime(stepWorkout)
            ExerciseType.STRESS -> setViewStress(stepWorkout)
        }
    }

    private fun setViewStress(stepWorkout: StepWorkout) {
        toast(stepWorkout)
        // TODO("Not yet implemented")
    }

    private fun setViewTime(stepWorkout: StepWorkout) {
        toast(stepWorkout)
        with(binding){
            stepLayout.root.visibility = View.INVISIBLE
            timeLayout.root.visibility = View.VISIBLE
        }
    }

    private fun setViewStep(stepWorkout: StepWorkout) {
        toast(stepWorkout)
        with(binding){
            stepLayout.root.visibility = View.VISIBLE
            timeLayout.root.visibility = View.INVISIBLE
        }
    }

    private fun toast(stepWorkout: StepWorkout) {
        Toast.makeText(requireContext(), stepWorkout.toString(), Toast.LENGTH_SHORT).show()
    }
}