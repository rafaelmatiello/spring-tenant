package net.matiello.multitenant.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.matiello.multitenant.model.Note;
import net.matiello.multitenant.repository.NoteRespository;

@Service
public class NoteService {

	@Autowired
	private NoteRespository noteRepository;

	@PersistenceContext
	public EntityManager entityManager;

	public NoteService(NoteRespository noteRespository) {
		noteRepository = noteRespository;
	}

	public List<Note> getAll() {
		return noteRepository.findAll();
	}

	public Note create(Note note) {
		return noteRepository.save(note);
	}
}
