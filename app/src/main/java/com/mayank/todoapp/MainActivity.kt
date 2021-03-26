package com.mayank.todoapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mayank.todoapp.data.initializer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),onclick {

    private val viewModel: viewModel by viewModels {
        ViewModelFactory((application as initializer).repository)
    }

    lateinit var adapter: adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter = adapter(this)
        todoRecycler.adapter = adapter
        viewModel.allTodo.observe(this,  {
            it?.let {
                adapter.updateData(it)
            }
        })
    }


    fun saveTodo(view:View){
        val text = todoEdittext.text.toString()
        if(text.isNotEmpty()){
            viewModel.addTodo(text)
            Toast.makeText(this,"Added : $text",Toast.LENGTH_SHORT)
        }
    }

    override fun onclick(text: String) {
        viewModel.deleteTodo(text)
        Toast.makeText(this,"Deleted : $text",Toast.LENGTH_SHORT)
    }
}