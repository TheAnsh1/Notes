package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {
    val allNotes: LiveData<List<Note>>
    private val repository: NoteRepository

    init {
        val dp =NoteDatabase.getDatabase(application).getNoteDao()
         repository =NoteRepository(dp)
        allNotes =repository.allNotes
    }
     fun deleteNode(note:Note)= viewModelScope.launch(Dispatchers.IO) {
      repository.delete(note)
     }
    fun insertNote(note:Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}