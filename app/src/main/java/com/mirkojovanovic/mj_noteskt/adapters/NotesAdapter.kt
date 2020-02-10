package com.mirkojovanovic.mj_noteskt.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkojovanovic.mj_noteskt.R
import com.mirkojovanovic.mj_noteskt.models.Note

class NotesAdapter(private val notes: ArrayList<Note>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val noteView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.note_view, parent, false)
        return ViewHolder(noteView)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note: Note = notes.get(position)
        holder.titleTextView.text = note.title
        holder.contentTextView.text = note.content
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView : AppCompatTextView = itemView
            .findViewById(R.id.note_view_title_text_view)
        var contentTextView : AppCompatTextView = itemView
            .findViewById(R.id.note_view_content_text_view)
    }
}