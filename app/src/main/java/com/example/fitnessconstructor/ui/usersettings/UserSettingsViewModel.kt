package com.example.fitnessconstructor.ui.usersettings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import com.example.fitnessconstructor.domain.StressUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserSettingsViewModel @Inject constructor(
    dataStore: DataStore<Preferences>,
    stressUseCase: StressUseCase
) : ViewModel() {
}