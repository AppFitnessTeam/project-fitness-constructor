package com.example.fitnessconstructor.ui.workoutlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessconstructor.databinding.FragmentWorkoutListBinding
import com.example.fitnessconstructor.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutListFragment :
    BaseFragment<FragmentWorkoutListBinding>(FragmentWorkoutListBinding::inflate) {

    private val viewModel: WorkoutListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initRecyclerView()

    }

    fun initRecyclerView(){
        var todoList = TODO("Add list of items for recycler")
        val adapter = WorkoutListAdapter(todoList,requireContext())
        binding.apply {
            recyclerWorkoutList.adapter = adapter
            recyclerWorkoutList.layoutManager = LinearLayoutManager(requireContext())

        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = WorkoutListFragment()
    }
}