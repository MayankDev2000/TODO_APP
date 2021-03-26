package com.mayank.todoapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todo")
class entity(@PrimaryKey @ColumnInfo(name = "data") var data:String){

}

