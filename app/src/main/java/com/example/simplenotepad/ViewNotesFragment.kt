package com.example.simplenotepad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ViewNotesFragment : Fragment() {

    private lateinit var textViewNotes: TextView
    private val notes = mutableListOf<Note>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_view_notes, container, false)

        textViewNotes = view.findViewById(R.id.textViewNotes)
        displayNotes()

        return view
    }

    // 方法用于显示笔记
    private fun displayNotes() {
        if (notes.isEmpty()) {
            textViewNotes.text = "No notes available"
        } else {
            val notesText = notes.joinToString("\n\n") { note ->
                "Title: ${note.title}\nContent: ${note.content}\nCategory: ${note.category}"
            }
            textViewNotes.text = notesText
        }
    }

    // 方法用于更新笔记列表
    fun updateNotes(newNotes: List<Note>) {
        notes.clear()
        notes.addAll(newNotes)
        displayNotes()
    }
}

