package com.mirkojovanovic.mj_noteskt.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mirkojovanovic.mj_noteskt.R
import com.mirkojovanovic.mj_noteskt.adapters.NotesAdapter
import com.mirkojovanovic.mj_noteskt.models.Note

import kotlinx.android.synthetic.main.activity_notes.*

const val GET_NOTE_REQUEST = 1

class NotesActivity : AppCompatActivity() {

    private lateinit var notesRecyclerView: RecyclerView
    private lateinit var notesAdapter: RecyclerView.Adapter<*>
    private lateinit var notesManager: RecyclerView.LayoutManager
    private lateinit var notesList: ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        setSupportActionBar(toolbar)
        setTitle(R.string.notes_activity_title)

        fab.setOnClickListener {
            startActivityForResult(Intent(this, AddNoteActivity::class.java),
                GET_NOTE_REQUEST)
        }

        notesManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        notesList = ArrayList()
        notesAdapter = NotesAdapter(notesList)

        notesRecyclerView = findViewById<RecyclerView>(R.id.notes_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = notesManager
            adapter = notesAdapter
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GET_NOTE_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                notesList.add(Note(data?.getStringExtra("title"),
                    data?.getStringExtra("content")))

                Log.e("ok", data?.getStringExtra("title"))
                notesAdapter.notifyDataSetChanged()
            }
        }
    }
}
