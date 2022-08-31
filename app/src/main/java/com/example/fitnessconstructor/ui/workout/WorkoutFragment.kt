package com.example.fitnessconstructor.ui.workout

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessconstructor.databinding.FragmentWorkoutBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutFragment : BaseFragment<FragmentWorkoutBinding>(FragmentWorkoutBinding::inflate) {

    private val viewModel: WorkoutViewModel by viewModels()
    private val args: WorkoutFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initRecyclerView()

    }

    fun initRecyclerView(){
        var todoList = TODO("Add list of items for recycler")
        val adapter = WorkoutAdapter(todoList,requireContext())
        binding.apply {
            recyclerWorkout.adapter = adapter
            recyclerWorkout.layoutManager = LinearLayoutManager(requireContext())

        }
    }


    companion object {

        @JvmStatic
        fun newInstance() = WorkoutFragment()
    }
}