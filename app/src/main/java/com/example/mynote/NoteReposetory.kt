package com.example.mynote

import androidx.lifecycle.LiveData

class NoteReposetory(private val noteDao:NoteDao) {
    val AllNode=noteDao.getAllNote()

    suspend fun insert(note:Note){
        noteDao.insert(note)
    }
    suspend fun delete(note:Note){
        noteDao.delete(note)
    }
}