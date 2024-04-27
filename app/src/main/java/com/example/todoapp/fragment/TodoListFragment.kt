package com.example.todoapp.fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.adapter.TodoListAdapter
import com.example.todoapp.database.TodoDatabase

class TodoListFragment :Fragment() {

    lateinit var todoRecyclerView: RecyclerView
    lateinit var adapter: TodoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todo_list_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        todoRecyclerView = view.findViewById(R.id.recyclerViewId)
        adapter = TodoListAdapter(null)
        todoRecyclerView.adapter = adapter
        // val item =TodoDatabase
        //  .getInstance(requireContext())
        //   .getTodosDao()
        //  .getAllTask()
        getTodosByDate()
    }

    fun getTodosByDate() {
        val todosList =

            TodoDatabase
                .getInstance(requireContext())
                .getTodosDao()
                .getAllTask()
        adapter.updateData(todoList = todosList)
        Log.e("ListTodo@A77a", todosList.size.toString())

    }
}