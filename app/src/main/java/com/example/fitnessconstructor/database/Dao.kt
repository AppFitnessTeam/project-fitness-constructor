package com.example.fitnessconstructor.database

import androidx.room.*
import androidx.room.Dao
import com.example.fitnessconstructor.database.entities.*
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {
    // Получаем список всех программ тренировок
    @Query("SELECT * FROM workout")
    fun getWorkout(): Flow<List<WorkoutEntity>>


    @Update // обновление по PrimaryKey
    suspend fun updateWorkout(workout: WorkoutEntity)// функция обновления программы, например нужно обновить значение isInList

    // получаем название упражнения по его номеру, а таже его номер типа(стресс, время, кол-во)
    @Query("SELECT * FROM all_exercises WHERE id IS :id")
    fun getExercise(id: Int?): Flow<AllExercisesEntity>

    // получаем название стрессупражнения по его номеру, а таже его номер типа(всегда будет 1)
    @Query("SELECT * FROM stress_exercises WHERE id IS :id")
    fun getStressExercise(id: Int?): Flow<StressExercisesEntity>

    // получаем тип упражнения(стресс, время, кол-во)
    @Query("SELECT * FROM type_exercises WHERE id IS :id")
    fun getTypeExercise(id: Int?): Flow<TypeExercisesEntity>

    // получаем время отдыха в зависимости от программы
    @Query("SELECT * FROM workout_rest WHERE workout_id IS :workoutId")
    fun getWorkoutRest(workoutId: Int?): Flow<WorkoutRestEntity>

    // получаем программу стресс теста
    @Query("SELECT * FROM stress_workout_exercises")
    fun getStressWorkoutExercises(): Flow<List<StressWorkoutExercisesEntity>>

    // получаем программу программу тренировки в зависимости от её номера и дня
    @Query("SELECT * FROM workout_exercises WHERE workout_id IS :workoutId AND day IS :day")
    fun getWorkoutExercises(workoutId: Int?, day: Int?): Flow<WorkoutExercises>
}
