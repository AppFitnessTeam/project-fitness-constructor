package com.example.fitnessconstructor.di

import android.content.Context
import androidx.room.Room
import com.example.fitnessconstructor.database.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideWorkoutDao(database: MainDataBase): WorkoutDao = database.getWorkoutDao()

    @Provides
    fun provideStressDao(database: MainDataBase): StressDao = database.getStressDao()

    @Provides
    fun provideWorkoutSettingsDao(database: MainDataBase): WorkoutSettingsDao =
        database.getWorkoutSettingsDao()

    @Provides
    fun provideCreateWorkoutDao(database: MainDataBase): CreateWorkoutDao =
        database.getCreateWorkoutDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MainDataBase {
        return Room.databaseBuilder(appContext, MainDataBase::class.java, "exercise.db")
            .createFromAsset("databases/init_database.db")
            .build()
    }
}