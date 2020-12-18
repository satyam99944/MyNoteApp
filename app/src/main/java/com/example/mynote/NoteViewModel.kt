package com.example.mynote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) :AndroidViewModel(application) {
val AllNotes:LiveData<List<Note>>
    private val reposetory:NoteReposetory
    init{
        val dao=NoteDataBase.getDatabase(application).noteDao()
        reposetory=NoteReposetory(dao)
        AllNotes=reposetory.AllNode
    }
    fun deleteNote(note:Note)=viewModelScope.launch(Dispatchers.IO){
        reposetory.delete(note)
    }

    fun insertNode(note:Note)=viewModelScope.launch(Dispatchers.IO){
        reposetory.insert(note)
    }
}