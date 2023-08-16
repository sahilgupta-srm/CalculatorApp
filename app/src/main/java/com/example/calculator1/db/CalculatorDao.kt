package com.example.calculator1.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CalculatorDao {
     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun saveeqn(equation: Calculator)

     @Query("DELETE FROM Calculator_data")
     suspend fun deleteeqn()

     @Query("Select * FROM Calculator_data")
     fun geteqn():List<Calculator>
    }
