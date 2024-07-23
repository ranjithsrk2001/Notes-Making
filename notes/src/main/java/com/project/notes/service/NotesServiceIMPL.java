package com.project.notes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.notes.DTO.NotesDTO;
import com.project.notes.DTO.NotesSaveDTO;
import com.project.notes.Repository.NotesRepo;
import com.project.notes.entity.NotesEntity;
@Service

public class NotesServiceIMPL implements Notes{

	@Autowired
	NotesRepo notesrepo;
	
	@Override
	public NotesEntity addNotes(NotesSaveDTO notesSaveDTO) {
		NotesEntity notesEntity = new NotesEntity();

	    notesEntity.setTitle(notesSaveDTO.getTitle());
	    notesEntity.setContent(notesSaveDTO.getContent());
	    notesEntity.setCategory(notesSaveDTO.getCategory());
	   notesEntity.setCreateddate(notesSaveDTO.getCreateddate());
	    notesEntity.setLatestUpdatedate(notesSaveDTO.getLatestdate());
	    notesrepo.save(notesEntity);
	    return notesEntity;
		
	}

	
	@Override
	public List<NotesDTO> getAllNotes() {
		List<NotesEntity> getAllNotes = notesrepo.findAll();
		List<NotesDTO> notesDTOList= new ArrayList<>();
		for(NotesEntity a:getAllNotes) {
			NotesDTO notesDTO = new NotesDTO(
					a.getId(),
					a.getTitle(),
					a.getContent(),
					a.getCategory(),
					a.getCreateddate(),
					a.getLatestUpdatedate()
					);
			notesDTOList.add(notesDTO);
		}
		
		return notesDTOList;
	}


	@Override
	public Optional<NotesEntity> getNotesById(int id) {
		Optional<NotesEntity> notes = notesrepo.findById(id);
		return notes;
	}



	
	@Override
	public Optional<NotesEntity> updateNotes(int id, NotesDTO notesDTODetails) {
	    Optional<NotesEntity> notesEntityOptional = notesrepo.findById(id);

	    if (notesEntityOptional.isPresent()) {
	        NotesEntity notesEntity = notesEntityOptional.get();
	        notesEntity.setTitle(notesDTODetails.getTitle());
	        notesEntity.setContent(notesDTODetails.getContent());
	        notesEntity.setCategory(notesDTODetails.getCategory());
	        notesEntity.setLatestUpdatedate(new Date()); 

	        // Save the updated entity and return it
	        return Optional.of(notesrepo.save(notesEntity));
	    } else {
	        // If the note with the given ID does not exist, return empty Optional
	        return Optional.empty();
	    }
	}

	

	public String deleteByid(int id) {
	    if (notesrepo.existsById(id)) {
	        notesrepo.deleteById(id);
	        return "{\"message\": \"Deleted\"}";
	    } else {
	        System.out.println("Customer id not found");
	        return "{\"message\": \"id not found\"}";
	    }
	}


	


	@Override
	public List<NotesDTO> getByCategory(String category) {
	    // Retrieve NotesEntity objects from the repository
	    List<NotesEntity> noteEntities = notesrepo.findAllByCategoryOrderByLatestUpdatedateDesc(category);

	    // Initialize a list to hold NotesDTO objects
	    List<NotesDTO> noteDTOs = new ArrayList<>();

	    // Convert NotesEntity objects to NotesDTO objects
	    for (NotesEntity entity : noteEntities) {
	        NotesDTO dto = new NotesDTO();
	        dto.setId(entity.getId());
	        dto.setTitle(entity.getTitle());
	        dto.setContent(entity.getContent());
	        dto.setCategory(entity.getCategory());
	        dto.setCreateddate(entity.getCreateddate());
	        dto.setLatestUpdatedate(entity.getLatestUpdatedate());
	        noteDTOs.add(dto);
	    }

	    return noteDTOs;
	}
}
