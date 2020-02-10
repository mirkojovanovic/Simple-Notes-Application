package com.mirkojovanovic.mj_noteskt.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mirkojovanovic.mj_noteskt.R
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        setTitle(R.string.add_note_activity_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        title_edit_text.requestFocus()

        add_button.setOnClickListener {
            val title: String = title_edit_text.text.toString()
            val content: String = content_edit_text.text.toString()

            val intent = Intent().apply {
                if (title.isNotEmpty()) {
                    putExtra("title", title)
                } else {
                    title_edit_text.error = "Title field is empty!"
                    return@setOnClickListener
                }

                if (content.isNotEmpty()) {
                    putExtra("content", content)
                } else {
                    content_edit_text.error = "Content field is empty!"
                    return@setOnClickListener
                }
            }

            if (title.isNotEmpty() && content.isNotEmpty()) {
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
