package com.mayank.todoapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(entity::class),version = 1,exportSchema = false)
 abstract class database :RoomDatabase(){
    abstract fun todoDao() : Dao

//    private class databsecallback(  private val scope: CoroutineScope
//    ) : RoomDatabase.Callback() {
//
//        override fun onCreate(db: SupportSQLiteDatabase) {
//            super.onCreate(db)
//            Instance?.let { database ->
//                scope.launch {
//                    populateDatabase(database.todoDao())
//                }
//            }
//        }

//        suspend fun populateDatabase(Dao: Dao) {
//            // Delete all content here.
//            // Add sample words.
//            var word = entity("Hello")
//            Dao.insert(word)
//            word = entity("World!")
//            Dao.insert(word)
//
//            // TODO: Add your own words!
//        }
//    }


    companion object{

        @Volatile
        private var Instance : database? = null

        fun getDatabase(context : Context,
                        scope: CoroutineScope
        ):database{
            return Instance ?: synchronized(this){
                val instance = Room.databaseBuilder(context,database::class.java,"Todo_Database").build()
                Instance = instance
                instance
            }
        }

    }
}