package com.project.notes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.notes.DTO.NotesDTO;
import com.project.notes.DTO.NotesSaveDTO;
import com.project.notes.Repository.NotesRepo;
import com.project.notes.entity.NotesEntity;
import com.project.notes.service.Notes;

@RestController
@CrossOrigin
@RequestMapping("api/v1/notes")
public class NotesController {

	@Autowired
	Notes notesService;
	
	@Autowired
	NotesRepo notesRepo;
	
	@PostMapping("")
	public NotesEntity addNotes(@RequestBody NotesSaveDTO notesSaveDTO) {
		 NotesEntity newNote = notesService.addNotes(notesSaveDTO);
		    return newNote;	
	}
	
	@GetMapping("")
	public List<NotesDTO> getData(){
		List<NotesDTO> list = notesService.getAllNotes();
		return list;
	}
	
	@GetMapping("/{id}")
	public Optional<NotesEntity> getNotesBy(@PathVariable int id) {
		Optional<NotesEntity> notes = notesService.getNotesById(id);
		return notes;
		
	}
	
	//total copy
	@PutMapping("/{id}")
		public ResponseEntity<?> updateNotes(@PathVariable int id, @RequestBody NotesDTO notesDTO) {
		    
		    Optional<NotesEntity> updatedNoteOptional = notesService.updateNotes(id, notesDTO);
		    
		    if (updatedNoteOptional.isPresent()) {
		       
		        return ResponseEntity.ok(updatedNoteOptional.get());
		    } else {
		      
		        return ResponseEntity.notFound().build();
		    }
		}
		
//	@DeleteMapping("/{id}")
//		public String deleteNotes(@PathVariable int id) {
//			String notes = notesService.deleteByid(id);
//			return notes;
//		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteNotes(@PathVariable int id) {
	    String message = notesService.deleteByid(id);
	    return ResponseEntity.ok().body(message);
	}
	
	@GetMapping("category/{category}")
	public List<NotesDTO> getByCategory(@PathVariable String category){
		List<NotesDTO> note = notesService.getByCategory(category);
		return note;
		
	}
		
}
