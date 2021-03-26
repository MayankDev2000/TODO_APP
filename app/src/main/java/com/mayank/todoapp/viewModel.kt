package com.mayank.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mayank.todoapp.data.repositry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewModel(repository: repositry):ViewModel() {
     var repository :repositry = repository
     var allTodo : LiveData<List<String>>
    init {
//        val dao = database.getDatabase(application).todoDao()
//         repository = repositry(dao)
         allTodo = repository.allTodo
    }

    fun deleteTodo(data : String) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(data)
    }

    fun addTodo(data:String) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(data)
    }
}
class ViewModelFactory(private val repository: repositry) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return viewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
