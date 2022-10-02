package com.example.fitnessconstructor.ui.workout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.ItemExerciseListBinding
import com.example.fitnessconstructor.domain.entities.Exercise

class WorkoutAdapter : RecyclerView.Adapter<WorkoutAdapter.WorkoutListHolder>() {

    private var data = emptyList<Exercise>()

    fun setData(listExercises: List<Exercise>) {
        data = listExercises
        notifyDataSetChanged()
    }

    class WorkoutListHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemExerciseListBinding.bind(item)

        fun bind(item: Exercise) = with(binding) {
            apply {
                exerciseNameTextView.text = item.name
                exerciseCountTextView.text =
                    if (item.count > 0) item.count.toString() else itemView.resources.getText(R.string.count_1)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutListHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_exercise_list, parent, false)
        return WorkoutListHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutListHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}