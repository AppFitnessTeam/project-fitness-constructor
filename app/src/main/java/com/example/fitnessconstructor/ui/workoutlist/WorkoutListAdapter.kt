package com.example.fitnessconstructor.ui.workoutlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.ItemWorkoutListBinding
import com.example.fitnessconstructor.domain.entities.Workout

class WorkoutListAdapter(
    val listener: ItemClickListener
) : RecyclerView.Adapter<WorkoutListAdapter.WorkoutListHolder>() {

    private var data = emptyList<Workout>()

    fun setData(workoutList: List<Workout>) {
        data = workoutList
        notifyDataSetChanged()
    }

    inner class WorkoutListHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemWorkoutListBinding.bind(item)

        fun bind(workout: Workout) = with(binding) {
            workoutNameTextView.text = workout.name
            workoutDescriptionTextView.text =
                itemView.resources.getString(R.string.workout_description_text, 2, 2) //TODO("set args from data")
            workoutStartButton.setOnClickListener { listener.onStartClick(workout) }
            workoutSettingsImageView.setOnClickListener { listener.onSettingsClick(workout) }
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
