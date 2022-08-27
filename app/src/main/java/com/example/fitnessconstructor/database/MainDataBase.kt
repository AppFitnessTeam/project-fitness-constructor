package com.example.fitnessconstructor.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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
        WorkoutExercises::class],
    version = 1,
    exportSchema = false
)

//  будет  давать доступ к ней
abstract class MainDataBase : RoomDatabase() {

    abstract fun getDao(): Dao // получаем доступ к интерфейсу  Dao

    companion object {

        fun getDataBase(context: Context): MainDataBase {
            val instanse = Room.databaseBuilder(
                context.applicationContext,   //context.applicationContext - контекст всего приложения
                MainDataBase::class.java,
                "exercise.db"
            ).createFromAsset("databases/exercise.db").build()
            return instanse


        }
    }
}
