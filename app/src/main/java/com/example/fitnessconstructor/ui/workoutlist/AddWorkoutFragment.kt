package com.example.fitnessconstructor.ui.workoutlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.fitnessconstructor.databinding.FragmentAddWorkoutBinding
import com.example.fitnessconstructor.domain.entities.Workout
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddWorkoutFragment :
    BaseFragment<FragmentAddWorkoutBinding>(FragmentAddWorkoutBinding::inflate),
    ItemWorkoutClickListener {

    private val viewModel: AddWorkoutViewModel by viewModels()
    private val adapter = AddWorkoutAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.allWorkoutList.observe(viewLifecycleOwner) { renderData(it) }
    }

    private fun renderData(allWorkoutList: List<Workout>) {
        adapter.setData(allWorkoutList)
    }

    private fun initViews() {
        with(binding) {
            allWorkoutRecyclerView.adapter = adapter
            crateWorkoutButton.setOnClickListener { toastBlock() }
            stressTestButton.setOnClickListener { toastBlock() }
        }
    }

    override fun onItemClick(workout: Workout) {
        toastBlock()
    }
}

interface ItemWorkoutClickListener {
    fun onItemClick(workout: Workout)
}