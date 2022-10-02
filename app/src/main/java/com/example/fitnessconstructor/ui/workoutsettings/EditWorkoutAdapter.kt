package com.example.fitnessconstructor.ui.workoutsettings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.ItemEditExerciseListBinding
import com.example.fitnessconstructor.domain.entities.Exercise

class EditWorkoutAdapter : RecyclerView.Adapter<EditWorkoutAdapter.WorkoutListHolder>() {

    private var data = emptyList<Exercise>()

    fun setData(listExercises: List<Exercise>) {
        data = listExercises
        notifyDataSetChanged()
    }

    fun getData():List<Exercise> = data

    class WorkoutListHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemEditExerciseListBinding.bind(item)

        fun bind(exercise: Exercise) = with(binding) {
            apply {
                exerciseNameTextView.text = exercise.name
                exerciseCountEditText.setText(exercise.count.toString())
                typeTextView.text = exercise.type.name
            }
        }

        fun updateDataItem(exercise: Exercise) = with(binding) {
            exercise.count = exerciseCountEditText.text.toString().toInt()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutListHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_edit_exercise_list, parent, false)
        return WorkoutListHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutListHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}