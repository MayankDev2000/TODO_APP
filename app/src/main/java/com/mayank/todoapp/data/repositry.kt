package com.mayank.todoapp.data

import androidx.lifecycle.LiveData
import com.mayank.todoapp.data.database.Dao
import com.mayank.todoapp.data.database.entity

class repositry(val dao : Dao) {
    val allTodo : LiveData<List<String>> = dao.getAllTodo()
    suspend fun insert(data: String){
        dao.insert(entity( data))
    }
    suspend fun delete(data: String){
        dao.delete(entity(data))
    }
}