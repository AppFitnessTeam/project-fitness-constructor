package com.example.fitnessconstructor.ui.workoutlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.FragmentAddWorkoutBinding
import com.example.fitnessconstructor.domain.entities.Workout
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddWorkoutFragment :
    BaseFragment<FragmentAddWorkoutBinding, AddWorkoutViewModel>(
        FragmentAddWorkoutBinding::inflate
    ), ItemWorkoutClickListener {

    override val viewModel: AddWorkoutViewModel by viewModels()
    private val adapter = AddWorkoutAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeNavigation()
        viewModel.allWorkoutList.observe(viewLifecycleOwner) { renderData(it) }
        viewModel.userLevel.observe(viewLifecycleOwner) { updateLevel(it) }
    }

    private fun updateLevel(userLevel: String) {
        binding.levelTextView.text = userLevel
    }

    private fun renderData(allWorkoutList: List<Workout>) {
        adapter.setData(allWorkoutList)
    }

    private fun initViews() {
        with(binding) {
            allWorkoutRecyclerView.adapter = adapter
            crateWorkoutButton.setOnClickListener { viewModel.createWorkout() }
            stressTestButton.setOnClickListener { startDialogTestDescription() }
        }
    }

    private fun startDialogTestDescription() {
        val dialog = AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setTitle(R.string.stress_test)
            .setMessage(R.string.stress_test_description)
            .setPositiveButton(R.string.start_test) { _, _ -> viewModel.startStressTest() }
            .setNegativeButton(R.string.skip_test) { dialog, _ -> dialog.dismiss() }
            .create()
        dialog.show()
    }

    override fun onItemClick(workout: Workout) {
        viewModel.addPreloadWorkout(workout.id)
    }
}

interface ItemWorkoutClickListener {
    fun onItemClick(workout: Workout)
}