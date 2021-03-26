package com.mayank.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter(var listen : onclick): RecyclerView.Adapter<adapter.viewHolder>() {
     var data : List<String> = mutableListOf("Hello" , "From","Mayank")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view  = viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_card,parent,false))
        view.button.setOnClickListener{
            listen.onclick(data.get(view.adapterPosition))
            notifyDataSetChanged()
        }
        return view
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.textView.text = data.get(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun updateData(newData : List<String>){
        data = newData
        notifyDataSetChanged()
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.TodoText)
        val button : ImageView = itemView.findViewById(R.id.TodoDelete)
    }
}
interface onclick{
    fun onclick(text:String)
}
