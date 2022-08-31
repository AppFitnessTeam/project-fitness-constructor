package com.example.fitnessconstructor.ui.workout


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.ItemWorkoutBinding
import com.example.fitnessconstructor.domain.Exercise


class WorkoutAdapter(
    todo: List<Exercise>, // Exercise!??
    context: Context
) : RecyclerView.Adapter<WorkoutAdapter.WorkoutListHolder>() {

    private val workoutItemList = todo
    private val contextAdapter = context

    class WorkoutListHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemWorkoutBinding.bind(item)

        fun bind(item: Exercise) = with(binding) {
            //TODO bind elements with item

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutListHolder {
        val view =
            LayoutInflater.from(contextAdapter).inflate(R.layout.item_workout, parent, false)
        return WorkoutListHolder(view)

    }

    override fun onBindViewHolder(holder: WorkoutListHolder, position: Int) {
        holder.bind(workoutItemList[position])
    }

    override fun getItemCount(): Int {
        return workoutItemList.size
    }

}