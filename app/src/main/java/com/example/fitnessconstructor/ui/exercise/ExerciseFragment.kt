package com.example.fitnessconstructor.ui.exercise

import com.example.fitnessconstructor.databinding.FragmentExerciseBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseFragment : BaseFragment<FragmentExerciseBinding>(FragmentExerciseBinding::inflate) {

    companion object {

        @JvmStatic
        fun newInstance() = ExerciseFragment()
    }
}