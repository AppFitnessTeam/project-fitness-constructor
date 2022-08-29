package com.example.fitnessconstructor.ui.exercise

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.fitnessconstructor.databinding.FragmentExerciseBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseFragment : BaseFragment<FragmentExerciseBinding>(FragmentExerciseBinding::inflate) {

    private val viewModel: ExerciseViewModel by viewModels()
    private val navArgs: ExerciseFragmentArgs by navArgs()

    companion object {

        @JvmStatic
        fun newInstance() = ExerciseFragment()
    }
}