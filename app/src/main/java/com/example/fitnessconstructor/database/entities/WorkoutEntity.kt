package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fitnessconstructor.domain.entities.Workout

@Entity(tableName = WorkoutEntity.TABLE_NAME)
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Int = 0,

    @ColumnInfo(name = COLUMN_NAME)
    val name: String,

    @ColumnInfo(name = COLUMN_NAME_RUS)
    val nameRus: String? = null,

    @ColumnInfo(name = COLUMN_IS_IN_LIST)
    val isInList: Int = 1,

    @ColumnInfo(name = COLUMN_DAY)
    val day: Int = 1,

    @ColumnInfo(name = COLUMN_USER_NAME)
    val userName: String? = null,

    @ColumnInfo(name = COLUMN_LVL)
    val lvl: String = DEFAULT_LEVEL,

    @ColumnInfo(name = COLUMN_IS_CUSTOM)
    val isCustomWorkout: Int = 1

) {

    fun toWorkout(): Workout {
        return Workout(
            id = id,
            name = name,
            nameRus = nameRus,
            isInList = isInList,
            day = day,
            userName = userName ?: name,
            lvl = lvl
        )
    }

    companion object {
        const val TABLE_NAME = "workout"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_NAME_RUS = "name_rus"
        const val COLUMN_LVL = "lvl"
        const val COLUMN_IS_IN_LIST = "is_in_list"
        const val COLUMN_DAY = "day"
        const val COLUMN_USER_NAME = "user_name"
        const val COLUMN_IS_CUSTOM = "is_custom"

        private const val DEFAULT_LEVEL = "Custom"
    }
}

