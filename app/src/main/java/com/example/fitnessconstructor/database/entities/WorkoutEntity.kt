package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fitnessconstructor.domain.entities.Workout
import java.io.Serializable

@Entity(tableName = WorkoutEntity.TABLE_NAME)
//таблица названий программ тренировок(пол, возраст, подготовка)
//список показываем на главном экране
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int = 0,

    @ColumnInfo(name = COLUMN_NAME) // колонка с именем программы
    val name: String,

    @ColumnInfo(name = COLUMN_IS_IN_LIST) //  указывает какие тренировки на главном экране, может принимать значение 0 или 1
    val isInList: Int?,

    @ColumnInfo(name = COLUMN_DAY) //  на каком дне остановился пользователь
    val day: Int?,

    @ColumnInfo(name = COLUMN_USER_NAME) // колонка с пользовательским именем программы
    val userName: String?

) : Serializable {

    fun toWorkout(): Workout {
        return Workout(
            id = this.id,
            name = this.name,
            stepsWorkout = mutableListOf(),
            day = this.day,
            userName = this.userName
        )
    }

    companion object {
        const val TABLE_NAME = "workout"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_IS_IN_LIST = "is_in_list"
        const val COLUMN_DAY = "day"
        const val COLUMN_USER_NAME = "user_name"
    }
}

