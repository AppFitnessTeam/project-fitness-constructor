package com.example.fitnessconstructor.ui.workoutlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.ItemWorkoutListBinding
import com.example.fitnessconstructor.domain.entities.Workout

class WorkoutListAdapter : RecyclerView.Adapter<WorkoutListAdapter.WorkoutListHolder>() {

    private var data = emptyList<Workout>()

    fun setData(workoutList: List<Workout>) {
        data = workoutList
        notifyDataSetChanged()
    }

    class WorkoutListHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemWorkoutListBinding.bind(item)

        fun bind(item: Workout) = with(binding) {
            workoutNameTextView.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutListHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_workout_list, parent, false)
        return WorkoutListHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutListHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
