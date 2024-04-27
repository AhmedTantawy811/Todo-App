package com.example.todoapp.database.model.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.database.model.TodoModel

@Dao
interface TodoDao {
    @Insert
    fun insertTask(todo: TodoModel)
    @Update
    fun updateTask(todo: TodoModel)
    @Delete
    fun deleteTask(todo: TodoModel)
    @Query("SELECT*FROM table_todo")
    fun getAllTask():List<TodoModel>
}