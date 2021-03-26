package com.mayank.todoapp.data

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class initializer:Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { com.mayank.todoapp.data.database.database.getDatabase(this,applicationScope) }
    val repository by lazy { repositry(database.todoDao()) }
}