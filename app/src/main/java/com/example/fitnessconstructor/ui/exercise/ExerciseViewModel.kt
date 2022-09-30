package com.example.fitnessconstructor.ui.exercise

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.*
import com.example.fitnessconstructor.di.PreferencesKeys
import com.example.fitnessconstructor.domain.StressUseCase
import com.example.fitnessconstructor.domain.entities.StepWorkout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val stressUseCase: StressUseCase,
    private val dataStore: DataStore<Preferences>
) : ViewModel() {

    private val navArgs = ExerciseFragmentArgs.fromSavedStateHandle(savedStateHandle)
    private val stepsWorkout = navArgs.stepsWorkout
    private val iteratorSteps = stepsWorkout.iterator()

    private val _stepWorkout = MutableLiveData<StepWorkout>()
    val stepWorkout: LiveData<StepWorkout> = _stepWorkout

    private val _isSteps = MutableLiveData<Boolean>()
    val isSteps: LiveData<Boolean> = _isSteps

    private val stressCount = mutableListOf<Int>()

    private val _stressMessage = MutableLiveData<String>()
    val stressMessage: LiveData<String> = _stressMessage

    init {
        nextStep()
    }

    fun nextStep() {
        if (iteratorSteps.hasNext()) {
            _stepWorkout.postValue(iteratorSteps.next())
        } else {
            _isSteps.postValue(false)
        }
    }

    fun addCount(count: Int) {
        viewModelScope.launch {
            if (iteratorSteps.hasNext()) {
                stressCount.add(count)
                _stepWorkout.postValue(iteratorSteps.next())
            } else {
                val stressResult = stressUseCase.getResult(stressCount.toTypedArray())
                dataStore.edit {
                    it[PreferencesKeys.userLevelKey] = stressResult
                }
                _stressMessage.postValue(stressResult)
            }
        }
    }

    suspend fun saveStressTestResult(stressResult: String) {
        dataStore.edit {
            it[PreferencesKeys.userLevelKey] = stressResult
        }
    }
}