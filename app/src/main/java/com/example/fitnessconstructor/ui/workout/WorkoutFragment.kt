package com.example.fitnessconstructor.ui.workout

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.fitnessconstructor.databinding.FragmentWorkoutBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutFragment : BaseFragment<FragmentWorkoutBinding>(FragmentWorkoutBinding::inflate) {

    private val viewModel: WorkoutViewModel by viewModels()
    private val args: WorkoutFragmentArgs by navArgs()

    companion object {

        @JvmStatic
        fun newInstance() = WorkoutFragment()
    }
}