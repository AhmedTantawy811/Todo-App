package com.example.todoapp.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "table_todo")
data class TodoModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    @ColumnInfo
    val title:String?=null,
    @ColumnInfo
    val descriptor:String?=null,
    @ColumnInfo
    val isDone:Boolean?=false,
    @ColumnInfo
    val time: Date ?=null,
    )