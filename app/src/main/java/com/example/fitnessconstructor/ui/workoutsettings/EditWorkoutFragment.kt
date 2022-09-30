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
    BaseFragment<FragmentEditWorkoutBinding>(FragmentEditWorkoutBinding::inflate) {

    private val viewModel: EditWorkoutViewModel by viewModels()
    private val args: EditWorkoutFragmentArgs by navArgs()

    private val adapter = EditWorkoutAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.exerciseList.observe(viewLifecycleOwner) { renderData(it) }
    }

    private fun renderData(exerciseList: List<Exercise>) {
        adapter.setData(exerciseList)
    }

    private fun initViews() {
        with(binding) {
            recyclerWorkoutList.adapter = adapter
            leftImageView.setOnClickListener { toastBlock() }
            rightImageView.setOnClickListener { toastBlock() }
            floatingActionButton.setOnClickListener { toastBlock() }
            saveButton.setOnClickListener { toastBlock() }
        }
    }
}