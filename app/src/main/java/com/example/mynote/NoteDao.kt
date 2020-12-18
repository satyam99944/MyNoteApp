package com.example.mynote

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict =OnConflictStrategy.IGNORE)
   suspend fun insert(note:Note)
    @Delete
    suspend fun delete(note:Note)
    @Query("select * from note_table order by id DESC")
    fun getAllNote():LiveData<List<Note>>
}