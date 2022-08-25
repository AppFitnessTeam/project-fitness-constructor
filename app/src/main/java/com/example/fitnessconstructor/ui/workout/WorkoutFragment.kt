package com.example.fitnessconstructor.ui.workout

import com.example.fitnessconstructor.databinding.FragmentWorkoutBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutFragment : BaseFragment<FragmentWorkoutBinding>(FragmentWorkoutBinding::inflate) {

    companion object {

        @JvmStatic
        fun newInstance() = WorkoutFragment()
    }
}