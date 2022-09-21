package com.example.fitnessconstructor.ui.workoutsettings

import androidx.navigation.fragment.navArgs
import com.example.fitnessconstructor.databinding.FragmentWorkoutSettingsBinding
import com.example.fitnessconstructor.ui.BaseFragment
import com.example.fitnessconstructor.ui.workout.WorkoutFragmentArgs
import dagger.hilt.android.AndroidEntryPoint
import java.sql.Time
import java.time.DayOfWeek

@AndroidEntryPoint
class WorkoutSettingsFragment :
    BaseFragment<FragmentWorkoutSettingsBinding>(FragmentWorkoutSettingsBinding::inflate),
    SetTimeByWeek {

    private val args: WorkoutSettingsFragmentArgs by navArgs()

    private fun createWeekList(): List<Pair<DayOfWeek, Time?>> {
        return listOf(
            Pair(DayOfWeek.SUNDAY, null),
            Pair(DayOfWeek.MONDAY, null),
            Pair(DayOfWeek.TUESDAY, null),
            Pair(DayOfWeek.WEDNESDAY, null),
            Pair(DayOfWeek.THURSDAY, null),
            Pair(DayOfWeek.FRIDAY, null),
            Pair(DayOfWeek.SATURDAY, null)
        )
    }

    override fun onSetTimeClick() {
        TODO("later")
    }
}


interface SetTimeByWeek {
    fun onSetTimeClick()
}