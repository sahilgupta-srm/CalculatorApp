package com.example.calculator1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[Calculator::class],version=1, exportSchema = false)
abstract class CalculatorDataClass : RoomDatabase(){
    abstract fun calculatordao():CalculatorDao


}