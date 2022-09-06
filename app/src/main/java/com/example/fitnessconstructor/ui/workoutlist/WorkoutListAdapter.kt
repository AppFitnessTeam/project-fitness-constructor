package com.example.fitnessconstructor.ui.workoutlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.ItemWorkoutListBinding
import com.example.fitnessconstructor.domain.entities.Workout

class WorkoutListAdapter(
    todo: List<Workout>, // Workout!??
    context: Context
) : RecyclerView.Adapter<WorkoutListAdapter.WorkoutListHolder>() {

    private val workoutList = todo
    private val contextAdapter = context

    class WorkoutListHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemWorkoutListBinding.bind(item)

        fun bind(item: Workout) = with(binding) {
            //TODO bind elements with item

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutListHolder {
        val view =
            LayoutInflater.from(contextAdapter).inflate(R.layout.item_workout_list, parent, false)
        return WorkoutListHolder(view)

    }

    override fun onBindViewHolder(holder: WorkoutListHolder, position: Int) {
        holder.bind(workoutList[position])
    }

    override fun getItemCount(): Int {
        return workoutList.size
    }

}
