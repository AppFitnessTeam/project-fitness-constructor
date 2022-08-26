package com.example.fitnessconstructor

import com.example.fitnessconstructor.databinding.FragmentWorkoutListBinding
import com.example.fitnessconstructor.ui.BaseFragment


class WorkoutListFragment :
    BaseFragment<FragmentWorkoutListBinding>(FragmentWorkoutListBinding::inflate) {



    companion object {
        @JvmStatic
        fun newInstance() = WorkoutListFragment()
    }

}
