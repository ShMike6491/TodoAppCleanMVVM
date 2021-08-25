package com.todotestapp.data.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.todotestapp.data.persistence.entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class TaskDataBase: RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        private const val DATABASE_NAME = "task_db"
        @Volatile
        private var INSTANCE: TaskDataBase? = null;

        fun getDatabase(context: Context): TaskDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance =
                    Room.databaseBuilder(context, TaskDataBase::class.java, DATABASE_NAME)
                        .build()
                INSTANCE = instance
                instance
            }
        }
    }
}