package com.example.fitnessconstructor.ui.workoutsettings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessconstructor.R
import com.example.fitnessconstructor.databinding.WeekListItemBinding
import java.sql.Time
import java.time.DayOfWeek

class WeekListAdapter(
    private val listener: SetTimeByWeek
) : RecyclerView.Adapter<WeekListAdapter.WeekListViewHolder>() {

    private var weekList = emptyList<Pair<DayOfWeek, Time?>>()

    fun setWeekList(newWeekList: List<Pair<DayOfWeek, Time?>>) {
        weekList = newWeekList
        notifyDataSetChanged()
    }

    fun getWeekList() = weekList

    inner class WeekListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = WeekListItemBinding.bind(itemView)

        fun bind(weekItem: Pair<DayOfWeek, Time?>) = with(binding) {
            dayOfWeekTextView.text = weekItem.first.name
            setTimeTextView.text = weekItem.second?.toString() ?: "set time"
            setTimeTextView.setOnClickListener { listener.onSetTimeClick() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.week_list_item, parent, false)
        return WeekListViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeekListViewHolder, position: Int) {
        holder.bind(weekList[position])
    }

    override fun getItemCount(): Int {
        return weekList.size
    }
}