package com.mayank.todoapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {

    @Query("Select * from todo ")
    fun getAllTodo(): LiveData<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data : entity)

    @Delete
    suspend fun delete(data: entity)
}