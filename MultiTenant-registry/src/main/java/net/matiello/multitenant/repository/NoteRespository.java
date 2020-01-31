package net.matiello.multitenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.matiello.multitenant.model.Note;

@Repository
public interface NoteRespository extends JpaRepository<Note, Long> {

}
