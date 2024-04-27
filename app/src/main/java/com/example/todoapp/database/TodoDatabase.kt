package com.example.todoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todoapp.database.model.Converters
import com.example.todoapp.database.model.Dao.TodoDao
import com.example.todoapp.database.model.TodoModel

@Database(entities = [TodoModel::class], version =2)
@TypeConverters(Converters::class)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun getTodosDao(): TodoDao
    companion object {
        private const val DATABASE_NAME = "Todos-Database"
        private var todoDatabaseInstance: TodoDatabase? = null

        fun getInstance(context: Context): TodoDatabase {
            if (todoDatabaseInstance == null) {
                todoDatabaseInstance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return todoDatabaseInstance!!
        }

    }

}