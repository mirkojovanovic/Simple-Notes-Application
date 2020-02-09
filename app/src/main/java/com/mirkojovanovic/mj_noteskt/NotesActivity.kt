package com.mirkojovanovic.mj_noteskt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        setSupportActionBar(toolbar)
        setTitle(R.string.notes_activity_title)

        fab.setOnClickListener { view ->
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }

}
