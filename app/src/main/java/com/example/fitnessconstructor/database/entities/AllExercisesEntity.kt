package com.example.fitnessconstructor.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable



@Entity(
    tableName = "all_exercises",
    foreignKeys = [
        ForeignKey(
            entity = TypeExercisesEntity::class,
            parentColumns = ["id"],
            childColumns = ["type_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)

data class AllExercisesEntity(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int?,

    @ColumnInfo(name = "name_eng") // колонка с аглийским названием упражнения
    val nameEng: String?,

    @ColumnInfo(name = "name_rus") // колонка с русским названием упражнения
    val nameRus: String?,

    @ColumnInfo(name = "type_id") // колонка с типом упражнения( стресс, количественный или на время)
    val typeId: Int?

)