package com.project.notes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.notes.entity.NotesEntity;

public interface NotesRepo extends JpaRepository<NotesEntity,Integer> {

	List<NotesEntity> findAllByCategoryOrderByLatestUpdatedateDesc(String category);

}
