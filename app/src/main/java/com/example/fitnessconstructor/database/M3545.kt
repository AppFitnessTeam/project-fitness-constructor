package com.example.fitnessconstructor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


//при первоначальном запуске можно будет выбрать на более 3 дней в неделю!!
// хотябы на первое время...

@Entity(tableName = "m3545")//таблица базы мужчин от 35 до 45
data class M3545(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int?,

    @ColumnInfo(name = "day") // какой день тренировки. Всего 3 дня тренировки в неделю
    val day: String,

    @ColumnInfo(name = "type_exercise") // номер упражнения из таблицы tabl_exercise
    val typExercise: Int?,

    @ColumnInfo(name = "time") // 2 значения. 0 - упражнение количественное, 1-упражнение на время
    val isExerciseTime: Int,

    @ColumnInfo(name = "num_appr") // количество подходов
    val nuAppr: Int?,

    @ColumnInfo(name = "one_new") // 1-й подход новичка
    val oneNew: Int?,

    @ColumnInfo(name = "two_new") // 2-й подход новичка
    val twoNew: Int?,

    @ColumnInfo(name = "three_new") // 3-й подход новичка
    val threeNew: Int?,

    @ColumnInfo(name = "one_ord") // 1-й подход обычного
    val oneOrd: Int?,

    @ColumnInfo(name = "two_ord") // 2-й подход обычного
    val twoOrd: Int?,

    @ColumnInfo(name = "three_ord") // 3-й подход обычного
    val threeOrd: Int?,

    @ColumnInfo(name = "one_hi") // 1-й подход спортсмена
    val oneHi: Int?,

    @ColumnInfo(name = "two_hi") // 2-й подход спортсмена
    val twoHi: Int?,

    @ColumnInfo(name = "three_hi") // 3-й подход спортсмена
    val threeHi: Int?,

    @ColumnInfo(name = "one_ex") // 1-й подход мастера
    val oneEx: Int?,

    @ColumnInfo(name = "two_ex") // 2-й подход мастера
    val twoEx: Int?,

    @ColumnInfo(name = "three_ex") // 3-й подход мастера
    val threeEx: Int?,

    ) : Serializable
