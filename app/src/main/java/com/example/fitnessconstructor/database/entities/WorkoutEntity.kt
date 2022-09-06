package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fitnessconstructor.domain.entities.Workout
import java.io.Serializable

@Entity(tableName = "workout")
//таблица названий программ тренировок(пол, возраст, подготовка)
//список показываем на главном экране
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int = 0,

    @ColumnInfo(name = "name") // колонка с именем программы
    val name: String,

    @ColumnInfo(name = "is_in_list") //  указывает какие тренировки на главном экране, может принимать значение 0 или 1
    val isInList: Int?

) : Serializable {

    fun toWorkout(): Workout {
        return Workout(id = this.id, name = this.name, stepsWorkout = mutableListOf())
    }
}

