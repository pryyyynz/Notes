package com.example.Notes.models;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.Notes.database.Note;
import com.example.Notes.database.NotesDao;
import com.example.Notes.database.NotesDatabase;

import java.util.List;

public class NotesRepository {

    private NotesDao notesDao;
    private LiveData<List<Note>> allNotes;

    NotesRepository(Application application) {
        NotesDatabase notesDatabase = NotesDatabase.getDatabase(application);
        notesDao = notesDatabase.notesDao();
        allNotes = notesDao.getAllNotes();
    }

    LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    void deleteNote(Note note) {
        notesDao.delete(note);
    }

    void insert(Note note) {
        NotesDatabase.databaseWriteExecutor.execute(() -> notesDao.insert(note));

    }


    Note getNoteById(int uid) {
        return notesDao.getNoteByUid(uid);
    }

}
