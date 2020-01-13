package com.medialink.consumerapp.helper

import android.database.Cursor
import com.medialink.consumerapp.db.DatabaseContract
import com.medialink.consumerapp.entity.Note

object MappingHelper {
    fun mapCursorToArrayList(notesCursor: Cursor): ArrayList<Note> {
        val notesList = ArrayList<Note>()
        notesCursor.moveToFirst()
        while (notesCursor.moveToNext()) {
            val id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
            val title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
            val description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
            val date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
            notesList.add(Note(id, title, description, date))
        }

        return notesList
    }

    fun mapCursorToObject(notesCursor: Cursor): Note {
        notesCursor.moveToNext()
        val id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
        val title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
        val description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
        val date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
        return Note(id, title, description, date)
    }
}