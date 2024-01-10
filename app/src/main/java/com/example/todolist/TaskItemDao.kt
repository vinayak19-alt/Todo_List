package com.example.todolist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.*
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import androidx.room.OnConflictStrategy

@Dao
interface TaskItemDao {
    @Query("SELECT * FROM task_item_table ORDER BY id ASC")
    fun allTaskItems(): Flow<List<TaskItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskItem(taskItem : TaskItem)
    @Update
    suspend fun updateTaskItem(taskItem : TaskItem)
    @Delete
    suspend fun deleteTaskItem(taskItem : TaskItem)
}