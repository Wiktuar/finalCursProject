package ru.wintuar.notebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.wintuar.notebook.entities.Note;
import ru.wintuar.notebook.services.NoteService;
import ru.wintuar.notebook.utils.Utils;

import java.util.Set;

@RestController
public class ServiceController {
    private NoteService noteService;

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/getnotes")
    public Set<Note> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping("/updatenote/{id}")
    public Note getNoteById(@PathVariable long id){
        return noteService.getNoteById(id);
    }

    @PostMapping("/addnote")
    public Note addNote(@RequestBody Note note){
        note.setDateTime(Utils.conbertTimetoStrimg());
        noteService.saveNote(note);
        note.setId(noteService.getNoteIdByDateTime(note.getDateTime()));
        return note;
    }

    @DeleteMapping("/deletenote/{id}")
    public HttpStatus deleteNoteById(@PathVariable long id){
        noteService.deleteNodeById(id);
        return HttpStatus.OK;
    }
}
