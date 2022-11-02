package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class NotesRVAdapter(private val context:Context, private val listener: INotesRVAdapter) : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    val allNotes =ArrayList<Note>()

    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView =itemView.findViewById<TextView>(R.id.Text)
       val deleteButton =itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder =NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteButton.setOnClickListener {

listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote =allNotes[position]
        holder.textView.text =currentNote.text

    }
     fun updateList(allList:List<Note>){
        allNotes.clear()
        allNotes.addAll(allList)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return  allNotes.size
    }
}
interface INotesRVAdapter{
    fun onItemClicked(note:Note)
}