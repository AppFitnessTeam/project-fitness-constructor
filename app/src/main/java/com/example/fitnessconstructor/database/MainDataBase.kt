package com.example.fitnessconstructor.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fitnessconstructor.database.entities.*

//аннотация что это база данных которая включает в себя следующие entity
@Database(
    entities = [
        AllExercisesEntity::class,
        StressExercisesEntity::class,
        StressWorkoutExercisesEntity::class,
        TypeExercisesEntity::class,
        WorkoutRestEntity::class,
        WorkoutEntity::class,
        WorkoutExercisesEntity::class],
    version = 1,
    exportSchema = true
)

//  будет  давать доступ к ней
abstract class MainDataBase : RoomDatabase() {

    abstract fun getWorkoutDao(): WorkoutDao
    abstract fun getStressDao(): StressDao
}
