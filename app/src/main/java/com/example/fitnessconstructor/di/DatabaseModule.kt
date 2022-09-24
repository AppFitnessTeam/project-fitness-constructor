package com.example.fitnessconstructor.di

import android.content.Context
import androidx.room.Room
import com.example.fitnessconstructor.database.MainDataBase
import com.example.fitnessconstructor.database.StressDao
import com.example.fitnessconstructor.database.WorkoutDao
import com.example.fitnessconstructor.database.WorkoutSettingsDao
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
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MainDataBase {
        return Room.databaseBuilder(appContext, MainDataBase::class.java, "exercise.db")
            .createFromAsset("databases/init_database.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}