package net.matiello.multitenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.matiello.multitenant.model.Note;
import net.matiello.multitenant.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	private NoteService noteService;

	public NoteController(NoteService noteService) {
		super();
		this.noteService = noteService;
	}

	@GetMapping
	public List<Note> findAll() {
		return noteService.getAll();
	}

	@PostMapping
	public Note create(@RequestBody Note note) {
		return noteService.create(note);
	}

}
