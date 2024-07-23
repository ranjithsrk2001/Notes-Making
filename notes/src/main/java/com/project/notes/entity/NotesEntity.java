package com.project.notes.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "allNotes")
public class NotesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",length=50)
	private int id;
	
	@Column(name="title",length=50)
	private String title;
	
	@Column(name="content",length=5000)
	private String content;
	
	@Column(name="category",length=50)

	private String category;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createddate",nullable = false)
	private Date createddate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LatestUpdatedate",nullable = false)
	private Date latestUpdatedate;
	
	
	@PrePersist
	
	private void onCreate() {
		createddate= new Date();
		latestUpdatedate = new Date();
	}
	
	public NotesEntity() {
		super();
	}

	public NotesEntity(String title, String content, String category, Date createddate,Date latestUpdatedate) {
		super();
		this.title = title;
		this.content = content;
		this.category = category;
		this.createddate = createddate;
		this.latestUpdatedate = latestUpdatedate;
	}

	public NotesEntity(int id, String title, String content, String category, Date createddate, Date latestUpdatedate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.category = category;
		this.createddate = createddate;
		this.latestUpdatedate = latestUpdatedate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getLatestUpdatedate() {
		return latestUpdatedate;
	}

	public void setLatestUpdatedate(Date latestUpdatedate) {
		this.latestUpdatedate = latestUpdatedate;
	}




	
}

