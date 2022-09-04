package com.example.fitnessconstructor.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Class for rest timer between exercises
 */
@Parcelize
data class Rest(
    val id: Int = 0,
    override val name: String = "Rest time",
    override val count: Int = 0
) : StepWorkout, Parcelable