package com.example.fitnessconstructor.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//аннотация что это база данных которая включает в себя следующие entity
@Database(
    entities = [
        ExerciseEntity::class,
        GroupEntity::class,
        M3545::class],
    version = 1
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
