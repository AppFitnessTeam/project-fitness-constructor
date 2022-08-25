package com.example.fitnessconstructor.ui.workoutlist

import com.example.fitnessconstructor.databinding.FragmentWorkoutListBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutListFragment :
    BaseFragment<FragmentWorkoutListBinding>(FragmentWorkoutListBinding::inflate) {

    companion object {
        @JvmStatic
        fun newInstance() = WorkoutListFragment()
    }
}