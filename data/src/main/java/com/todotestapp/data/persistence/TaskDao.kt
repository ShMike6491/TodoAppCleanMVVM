package com.todotestapp.data.persistence

import androidx.room.*
import com.todotestapp.data.persistence.entities.TaskEntity
import com.todotestapp.data.repositories.ILocalStorage
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao : ILocalStorage {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    override suspend fun insert(task: TaskEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg tasks: TaskEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tasks: List<TaskEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun update(task: TaskEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(vararg tasks: TaskEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(tasks: List<TaskEntity>)

    @Delete
    suspend fun delete(task: TaskEntity)

    @Delete
    suspend fun delete(vararg tasks: TaskEntity)

    @Delete
    suspend fun delete(tasks: List<TaskEntity>)

    @Query("DELETE FROM tasks")
    override suspend fun deleteAll()

    @Query("DELETE FROM tasks WHERE id = :id")
    override suspend fun deleteById(id: Int)

    @Query("SELECT * FROM tasks")
    override fun getAll(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks WHERE id = :id LIMIT 1")
    override suspend fun findById(id: Int): TaskEntity?
}