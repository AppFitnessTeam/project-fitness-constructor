package com.example.fitnessconstructor.domain.entities

import android.os.Parcelable

interface StepWorkout : Parcelable {
    val name: String
    val count: Int
}