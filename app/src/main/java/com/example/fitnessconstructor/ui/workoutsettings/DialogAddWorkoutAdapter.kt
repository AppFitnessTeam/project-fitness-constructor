package com.example.fitnessconstructor.ui.workoutsettings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.ItemExerciseListBinding
import com.example.fitnessconstructor.domain.entities.Exercise

class DialogAddWorkoutAdapter(
    private val data: List<Exercise>,
    private val click: OnExerciseClick
) : RecyclerView.Adapter<DialogAddWorkoutAdapter.DialogAddWorkoutHolder>() {

    inner class DialogAddWorkoutHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemExerciseListBinding.bind(item)

        fun bind(item: Exercise) = with(binding) {
            apply {
                exerciseNameTextView.text = item.name
                itemView.setOnClickListener { click.onExerciseClick(item) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogAddWorkoutHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_exercise_list, parent, false)
        return DialogAddWorkoutHolder(view)
    }

    override fun onBindViewHolder(holder: DialogAddWorkoutHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}