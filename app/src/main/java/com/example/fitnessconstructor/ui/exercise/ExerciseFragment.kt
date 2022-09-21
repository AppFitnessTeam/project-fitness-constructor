package com.example.fitnessconstructor.ui.exercise

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.FragmentExerciseBinding
import com.example.fitnessconstructor.domain.entities.ExerciseType
import com.example.fitnessconstructor.domain.entities.Rest
import com.example.fitnessconstructor.domain.entities.StepWorkout
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseFragment : BaseFragment<FragmentExerciseBinding>(FragmentExerciseBinding::inflate) {

    private val viewModel: ExerciseViewModel by viewModels()
    private val navArgs: ExerciseFragmentArgs by navArgs()

    private var timer: CountDownTimer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.isSteps.observe(viewLifecycleOwner) { skipWorkout() }
        viewModel.stepWorkout.observe(viewLifecycleOwner) { renderData(it) }
    }

    private fun initView() {
        with(binding) {
            buttonNext.setOnClickListener {
                timer?.cancel()
                viewModel.nextStep()
            }
            buttonSkip.setOnClickListener {
                skipWorkout()
            }
        }
    }

    private fun skipWorkout() {
        timer?.cancel()
        findNavController().navigateUp()
    }

    private fun renderData(stepWorkout: StepWorkout) {
        if (stepWorkout.javaClass.name == Rest::class.java.name) {
            setRestLayout(stepWorkout)
        } else {
            setExerciseLayout(stepWorkout)
        }
    }

    private fun setExerciseLayout(stepWorkout: StepWorkout) {
        with(binding) {
            exerciseLayout.root.visibility = View.VISIBLE
            restLayout.root.visibility = View.INVISIBLE
            exerciseLayout.exerciseTypeTextView.text = stepWorkout.type.name
            exerciseLayout.exerciseNameTextView.text = stepWorkout.name
        }
        when (stepWorkout.type) {
            ExerciseType.STEP -> setViewStep(stepWorkout)
            ExerciseType.TIME -> setViewTime(stepWorkout)
            ExerciseType.STRESS -> setViewStress(stepWorkout)
        }
    }

    private fun setRestLayout(stepWorkout: StepWorkout) {
        with(binding) {
            exerciseLayout.root.visibility = View.INVISIBLE
            restLayout.root.visibility = View.VISIBLE
            timer = createTimer(stepWorkout.count) {
                restLayout.restCountTextView.text = it.toString()
            }.start()
        }
    }

    private fun setViewStress(stepWorkout: StepWorkout) {
        // TODO("Not yet implemented")
    }

    private fun setViewTime(stepWorkout: StepWorkout) {
        with(binding.exerciseLayout) {
            textInputLayout.visibility = View.INVISIBLE
            timer = createTimer(stepWorkout.count) {
                exerciseCountTextView.text = it.toString()
            }.start()
        }
    }

    private fun setViewStep(stepWorkout: StepWorkout) {
        with(binding.exerciseLayout) {
            stepsEditText.visibility = View.VISIBLE
            textInputLayout.visibility = View.VISIBLE
            if (stepWorkout.count < 0) {
                exerciseCountTextView.text = resources.getText(R.string.count_1)
                exerciseTypeTextView.visibility = View.INVISIBLE
            } else {
                exerciseTypeTextView.visibility = View.VISIBLE
                exerciseCountTextView.text = stepWorkout.count.toString()
                stepsEditText.setText(stepWorkout.count.toString())
            }
        }
    }

    override fun onPause() {
        super.onPause()
        timer?.cancel()
    }

    private fun createTimer(time: Int, renderView: (Long) -> Unit): CountDownTimer {
        return object : CountDownTimer(time.toLong() * 1000, 1000) {
            override fun onTick(p0: Long) {
                renderView(p0 / 1000)
            }

            override fun onFinish() {
                viewModel.nextStep()
            }
        }
    }
}