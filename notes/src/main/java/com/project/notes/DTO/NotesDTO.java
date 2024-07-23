package com.project.notes.DTO;

import java.util.Date;

public class NotesDTO {

	private int id;
	private String title;
	private String content;
	private String category;
	private Date createddate;
	private Date LatestUpdatedate;
	
	public NotesDTO() {
		super();
	}

	public NotesDTO(String title, String content, String category, Date createddate, Date latestUpdatedate) {
		super();
		this.title = title;
		this.content = content;
		this.category = category;
		this.createddate = createddate;
		LatestUpdatedate = latestUpdatedate;
	}

	public NotesDTO(int id, String title, String content, String category, Date createddate, Date latestUpdatedate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.category = category;
		this.createddate = createddate;
		LatestUpdatedate = latestUpdatedate;
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
		return LatestUpdatedate;
	}

	public void setLatestUpdatedate(Date latestUpdatedate) {
		LatestUpdatedate = latestUpdatedate;
	}
	
	
}

