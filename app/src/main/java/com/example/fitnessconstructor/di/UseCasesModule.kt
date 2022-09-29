package com.example.fitnessconstructor.di

import com.example.fitnessconstructor.data.CreateWorkoutUseCaseImpl
import com.example.fitnessconstructor.data.StressUseCaseImpl
import com.example.fitnessconstructor.data.WorkoutSettingsUseCaseImpl
import com.example.fitnessconstructor.data.WorkoutUseCaseImpl
import com.example.fitnessconstructor.domain.CreateWorkoutUseCase
import com.example.fitnessconstructor.domain.StressUseCase
import com.example.fitnessconstructor.domain.WorkoutSettingsUseCase
import com.example.fitnessconstructor.domain.WorkoutUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCasesModule {

    @Binds
    @Singleton
    abstract fun bindStressUseCase(impl: StressUseCaseImpl): StressUseCase

    @Binds
    @Singleton
    abstract fun bindCreateWorkoutUseCase(impl: CreateWorkoutUseCaseImpl): CreateWorkoutUseCase

    @Binds
    @Singleton
    abstract fun bindWorkoutUseCase(impl: WorkoutUseCaseImpl): WorkoutUseCase

    @Binds
    @Singleton
    abstract fun bindWorkoutSettingsUseCase(impl: WorkoutSettingsUseCaseImpl): WorkoutSettingsUseCase
}