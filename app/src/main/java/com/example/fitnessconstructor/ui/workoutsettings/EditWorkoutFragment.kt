package com.example.fitnessconstructor.ui.workoutsettings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.fitnessconstructor.databinding.FragmentEditWorkoutBinding
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditWorkoutFragment :
    BaseFragment<FragmentEditWorkoutBinding, EditWorkoutViewModel>(FragmentEditWorkoutBinding::inflate) {

    override val viewModel: EditWorkoutViewModel by viewModels()
    private val args: EditWorkoutFragmentArgs by navArgs()

    private val adapter = EditWorkoutAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeNavigation()
        viewModel.exerciseList.observe(viewLifecycleOwner) { renderData(it) }
        viewModel.day.observe(viewLifecycleOwner) { renderDay(it) }
    }

    private fun renderDay(day: Int) {
        binding.dayTextView.text = day.toString()
    }

    private fun renderData(exerciseList: List<Exercise>) {
        adapter.setData(exerciseList)
    }

    private fun initViews() {
        with(binding) {
            recyclerWorkoutList.adapter = adapter
            leftImageView.setOnClickListener { viewModel.previousDay() }
            rightImageView.setOnClickListener { viewModel.nextDay() }
            saveButton.setOnClickListener { toastBlock() } //TODO("add function")
            saveButton.setOnClickListener { toastBlock() } //TODO("add function")
        }
    }
}