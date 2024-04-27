package com.example.todoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todoapp.R
import com.example.todoapp.database.model.TodoModel

class TodoListAdapter (private var todoList:List<TodoModel>?=null):
    Adapter<TodoListAdapter.TodoListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_list, parent, false)
        return TodoListViewHolder(view)
    }
    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        val item=todoList?.get(position)
        holder.title.text=item?.title
        holder.time.text=item?.time.toString()
    }
    fun updateData(todoList: List<TodoModel>?) {
        this.todoList = todoList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return todoList?.size ?: 0
    }
    class TodoListViewHolder(val view:View):ViewHolder(view){
        val title:TextView =view.findViewById(R.id.title_Task_Te)
        val time:TextView =view.findViewById(R.id.time_todo_task)

    }

}