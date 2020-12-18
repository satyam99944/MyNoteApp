package com.example.mynote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),InoteRVAdopter{
    lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager=LinearLayoutManager(this)
        val adopter=NoteRVAdopter(this,this)
       // val adopter=NoteRVAdopter(this,this)
        recycler_view.adapter=adopter
        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(NoteViewModel::class.java)
        viewModel.AllNotes.observe(this, Observer {list->
            list?.let {
                adopter.update(it)
            }

        })

    }

    override fun onItemClicked(note: Note) {
      viewModel.deleteNote(note)
    }

    fun submitData(view: View) {
        val noteText=note_text.text.toString()
        if(noteText.isNotEmpty()){
            viewModel.insertNode(Note(noteText))
        }
        note_text.setText("")
    }
}