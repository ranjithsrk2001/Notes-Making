package com.project.notes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.project.notes.DTO.NotesDTO;
import com.project.notes.DTO.NotesSaveDTO;
import com.project.notes.entity.NotesEntity;

public interface Notes {

	NotesEntity addNotes(NotesSaveDTO notesSaveDTO);

	List<NotesDTO> getAllNotes();

	Optional<NotesEntity> getNotesById(int id);

	Optional<NotesEntity> updateNotes(int id, NotesDTO notesDTO);

	String deleteByid(int id);

	List<NotesDTO> getByCategory(String category);
	

}
