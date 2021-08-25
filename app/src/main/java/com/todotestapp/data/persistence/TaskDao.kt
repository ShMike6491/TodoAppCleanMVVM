package com.todotestapp.data.persistence

import androidx.room.*
import com.todotestapp.data.persistence.entities.TaskEntity
import com.todotestapp.data.repositories.ILocalStorage

@Dao
interface TaskDao : ILocalStorage {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    override fun insert(task: TaskEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg tasks: TaskEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tasks: List<TaskEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    override fun update(task: TaskEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg tasks: TaskEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(tasks: List<TaskEntity>)

    @Delete
    fun delete(task: TaskEntity)

    @Delete
    fun delete(vararg tasks: TaskEntity)

    @Delete
    fun delete(tasks: List<TaskEntity>)

    @Query("DELETE FROM tasks")
    override fun deleteAll()

    @Query("DELETE FROM tasks WHERE id = :id")
    override fun deleteById(id: Int)

    @Query("SELECT * FROM tasks")
    override fun getAll(): List<TaskEntity>

    @Query("SELECT * FROM tasks WHERE id = :id LIMIT 1")
    override fun findById(id: Int): TaskEntity?
}