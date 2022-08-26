package com.example.fitnessconstructor.database

import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {
    // Получаем список всех групп
    @Query("SELECT * FROM groups")
    fun getAllGroups(): List<GroupEntity>

    // получаем список нозваний упражнений
    @Query("SELECT * FROM tabl_exercise WHERE id IS :id")
    fun getExerciseNames(id: Int?): List<ExerciseEntity>

    /*
    пример выборки по номеру упражнения id=1
    List<ExerciseEntity(1,"Warm up","Разминка")>
     */

    /*
     выборка по дню. Получаем все упражнения для первого, второго иили третьего дня тненировки.
     Список упражнений. В нем:
     номер упражнения,
     количесвивенный или на время,
     количество подходов,
     и 12 значений для всех 4-х типов(новичек, обычный, высокий, превосходный), тут некоторые значения могут быть:
      - null (например 1 в упражнении 1 подход, по в подходах 2 и будет null)
      - "-1" - когда упражнение делается до отказа
          */
    @Query("SELECT * FROM m3545 WHERE day IS :day")
    fun getExerciseForDayForM3545(day: Int?): List<M3545>

    /*
   пример выборки по номеру дня day=1
   List<
   M3545(1,1,1,1,1,180,null,null,240,null,null,300,null,null,360,null,null),
   M3545(2,1,2,0,3,12,10,-1,15,12,-1,20,18,-1,30,30,-1),
   M3545(3,1,3,1,3,30,30,30,30,30,30,30,30,30,30,30,30),
   M3545(4,1,4,0,2,-1,-1,null,-1,-1,null,-1,-1,null,-1,-1,null),
   M3545(5,1,5,1,1,60,null,null,60,null,null,60,null,null,60,null,null)
   >
    */

}
