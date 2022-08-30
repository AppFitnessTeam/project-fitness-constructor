package com.example.fitnessconstructor.ui.workoutlist

import androidx.fragment.app.viewModels
import com.example.fitnessconstructor.databinding.FragmentWorkoutListBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutListFragment :
    BaseFragment<FragmentWorkoutListBinding>(FragmentWorkoutListBinding::inflate) {

    private val viewModel: WorkoutListViewModel by viewModels()

    companion object {
        @JvmStatic
        fun newInstance() = WorkoutListFragment()
    }
}