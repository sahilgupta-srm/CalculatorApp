package com.example.calculator1.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Calculator_data")
data class Calculator(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="Equation_no")
    val id:Int,
    @ColumnInfo(name="Equation")
    val equation:String,
    @ColumnInfo(name="Answer")
    val ans:Double


    )