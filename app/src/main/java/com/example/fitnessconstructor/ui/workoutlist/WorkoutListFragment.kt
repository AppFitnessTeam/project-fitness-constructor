package com.example.fitnessconstructor.ui.workoutlist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fitnessconstructor.databinding.FragmentWorkoutListBinding
import com.example.fitnessconstructor.databinding.WorkoutSettingsDialogBinding
import com.example.fitnessconstructor.domain.entities.Workout
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import java.sql.Time
import java.time.DayOfWeek

@AndroidEntryPoint
class WorkoutListFragment :
    BaseFragment<FragmentWorkoutListBinding>(FragmentWorkoutListBinding::inflate),
    ItemClickListener {

    private val viewModel: WorkoutListViewModel by viewModels()
    private val adapter = WorkoutListAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.workoutList.observe(viewLifecycleOwner) { renderData(it) }
    }

    private fun renderData(list: List<Workout>) {
        adapter.setData(list)
    }

    private fun initViews() {
        binding.apply {
            recyclerWorkoutList.adapter = adapter
            floatingActionButton.setOnClickListener {
                toastBlock()
                //TODO("add create workout")
            }
        }
    }

    override fun onStartClick(workout: Workout) {
        val action =
            WorkoutListFragmentDirections.actionWorkoutListFragmentToWorkoutFragment(workout.id)
        findNavController().navigate(action)
    }

    override fun onSettingsClick(workout: Workout) {
        showWorkoutSettingsDialog()
    }

    //TODO("Not yet implemented")
    private fun toastBlock() {
        Toast.makeText(requireContext(), "Not yet implemented", Toast.LENGTH_SHORT).show()
    }

    private fun showWorkoutSettingsDialog() {
        //TODO("add workout settings from viewModel")
        val dialogBinding = WorkoutSettingsDialogBinding.inflate(layoutInflater)
        dialogBinding.weekNotificationRecyclerView.adapter = WeekListAdapter(createWeekList())
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
            .setCancelable(true)
            //TODO("update workout settings by viewModel")
            .create()
        dialog.show()
    }

    private fun createWeekList(): List<Pair<DayOfWeek, Time?>> {
        return listOf(
            Pair(DayOfWeek.SUNDAY, null),
            Pair(DayOfWeek.MONDAY, null),
            Pair(DayOfWeek.TUESDAY, null),
            Pair(DayOfWeek.WEDNESDAY, null),
            Pair(DayOfWeek.THURSDAY, null),
            Pair(DayOfWeek.FRIDAY, null),
            Pair(DayOfWeek.SATURDAY, null)
        )
    }
}

interface ItemClickListener {
    fun onStartClick(workout: Workout)
    fun onSettingsClick(workout: Workout)
}