package com.example.fitnessconstructor.di

import com.example.fitnessconstructor.data.StressUseCaseImpl
import com.example.fitnessconstructor.domain.StressUseCase
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
}