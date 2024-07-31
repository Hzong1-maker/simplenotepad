package com.example.simplenotepad

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private val notes = mutableListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load the initial fragment
        if (savedInstanceState == null) {
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, AddNoteFragment())
            transaction.commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.action_add_note -> {
                transaction.replace(R.id.fragment_container, AddNoteFragment())
                transaction.commit()
                return true
            }
            R.id.action_view_notes -> {
                val viewNotesFragment = ViewNotesFragment()
                viewNotesFragment.updateNotes(notes)
                transaction.replace(R.id.fragment_container, viewNotesFragment)
                transaction.commit()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}



