package com.example.fitnessconstructor.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.fitnessconstructor.database.entities.*
import kotlinx.coroutines.flow.Flow


@Dao
interface WorkoutDao {
    // Получаем список всех программ тренировок
    @Query("SELECT * FROM workout")
    fun getWorkout(): Flow<List<WorkoutEntity>>

    @Update // обновление по PrimaryKey
    suspend fun updateWorkout(workout: WorkoutEntity)// функция обновления программы, например нужно обновить значение isInList

    // получаем название упражнения по его номеру, а таже его номер типа(стресс, время, кол-во)
    @Query("SELECT * FROM all_exercises WHERE id IS :id")
    fun getExercise(id: Int?): Flow<AllExercisesEntity>

    // получаем тип упражнения(стресс, время, кол-во)
    @Query("SELECT * FROM type_exercises WHERE id IS :id")
    fun getTypeExercise(id: Int?): Flow<TypeExercisesEntity>

    // получаем время отдыха в зависимости от программы
    @Query("SELECT * FROM workout_rest WHERE workout_id IS :workoutId")
    suspend fun getWorkoutRest(workoutId: Int?): WorkoutRestEntity

    // получаем программу программу тренировки в зависимости от её номера и дня
    @Query("SELECT * FROM workout_exercises WHERE workout_id IS :workoutId AND day IS :day")
    suspend fun getWorkoutExercises(workoutId: Int?, day: Int?): List<WorkoutExercises>
}
