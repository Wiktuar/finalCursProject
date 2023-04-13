package ru.wintuar.notebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.wintuar.notebook.entities.Note;
import ru.wintuar.notebook.repository.NoteRepo;

import java.util.Set;

@Service
public class NoteService {

    private NoteRepo noteRepo;

    @Autowired
    public void setNoteRepo(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    //получение всех записей записной книнжки
    public Set<Note> getAllNotes(){
        return noteRepo.findAll();
    }
    public void saveNote(Note note){
        noteRepo.save(note);
    }

    public Note getNoteById(long id){
        return noteRepo.getNoteById(id);
    }

    //получение Id записки по метке времени
    public Long getNoteIdByDateTime(String dateTime){
        return noteRepo.getNoteIdByDateTime(dateTime);
    }

    // удаление записки
    public void deleteNodeById(long id){
        noteRepo.deleteById(id);
    }
}
