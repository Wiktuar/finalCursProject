package ru.wintuar.notebook.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.wintuar.notebook.entities.Note;

import java.util.Set;

@Repository
public interface NoteRepo extends CrudRepository<Note, Long> {

    @Query("select n from Note n")
    Set<Note> findAll();

    @Query("select n.id from Note n where n.dateTime = :dateTime")
    Long getNoteIdByDateTime(@Param("dateTime") String dateTime);
    Note getNoteById(Long ld);
}
