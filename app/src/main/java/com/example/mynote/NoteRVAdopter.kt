package com.example.mynote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    class NoteRVAdopter(private val context: Context, private val listner: MainActivity): RecyclerView.Adapter<NoteRVAdopter.NoteViewHolder>() {
        var allNotes=ArrayList<Note>()

        inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val text_view=itemView.findViewById<TextView>(R.id.textView)
            val delete=itemView.findViewById<ImageView>(R.id.delete)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
            val viewHolder=NoteViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.note_layout, parent
                            , false
                    ))
            viewHolder.delete.setOnClickListener {
                listner.onItemClicked(allNotes[viewHolder.adapterPosition])
            }
            return viewHolder
        }

        override fun getItemCount(): Int {
            return allNotes.size
        }

        override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            var currentNote=allNotes[position]
            holder.text_view.text=currentNote.text
        }
        fun update(newList:List<Note>){
            allNotes.clear()
            allNotes.addAll(newList)
            notifyDataSetChanged()
        }
    }
    interface InoteRVAdopter{
        fun onItemClicked(note: Note)
    }
