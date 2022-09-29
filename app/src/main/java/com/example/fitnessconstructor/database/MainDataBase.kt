package com.example.fitnessconstructor.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fitnessconstructor.database.entities.*

@Database(
    entities = [
        AllExercisesEntity::class,
        StressExercisesEntity::class,
        StressWorkoutExercisesEntity::class,
        TypeExercisesEntity::class,
        WorkoutRestEntity::class,
        WorkoutEntity::class,
        WorkoutExercisesEntity::class,
        WorkoutNotificationEntity::class],
    version = 1,
    exportSchema = true
)

abstract class MainDataBase : RoomDatabase() {

    abstract fun getWorkoutDao(): WorkoutDao
    abstract fun getStressDao(): StressDao
    abstract fun getWorkoutSettingsDao(): WorkoutSettingsDao
    abstract fun getCreateWorkoutDao(): CreateWorkoutDao
}
