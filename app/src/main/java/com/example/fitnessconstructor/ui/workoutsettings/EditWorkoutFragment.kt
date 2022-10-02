package com.example.fitnessconstructor.ui.workoutsettings

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.DialogExercisesListBinding
import com.example.fitnessconstructor.databinding.FragmentEditWorkoutBinding
import com.example.fitnessconstructor.domain.entities.Exercise
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditWorkoutFragment :
    BaseFragment<FragmentEditWorkoutBinding, EditWorkoutViewModel>(FragmentEditWorkoutBinding::inflate),
    OnExerciseClick {

    override val viewModel: EditWorkoutViewModel by viewModels()
    private val args: EditWorkoutFragmentArgs by navArgs()

    private val adapter = EditWorkoutAdapter()

    private var dialog: AlertDialog? = null

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
            addExerciseButton.setOnClickListener { showDialogAddWorkout() }
            saveButton.setOnClickListener { toastBlock() } //TODO("add function")
            cancelButton.setOnClickListener { viewModel.navigateBack() }
        }
    }

    private fun showDialogAddWorkout() {
        val dialogBinding = DialogExercisesListBinding.inflate(layoutInflater)
        dialogBinding.allExercisesRecyclerView.adapter =
            DialogAddWorkoutAdapter(viewModel.allExercisesList, this)
        dialog = AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
            .setTitle(R.string.add_dialog_title)
            .setNegativeButton(R.string.text_cancel_button) { dialog, _ -> dialog.dismiss() }
            .create()
        dialog?.show()
    }

    override fun onExerciseClick(exercise: Exercise) {
        viewModel.addExercise(exercise)
        dialog?.dismiss()
    }
}

interface OnExerciseClick {
    fun onExerciseClick(exercise: Exercise)
}