package com.project.notes.DTO;

import java.util.Date;

public class NotesSaveDTO {


	private String title;
	private String content;
	private String category;
	private Date createddate;
	private Date latestdate;
	
	
	public NotesSaveDTO() {
		super();
	}

	public NotesSaveDTO( String title, String content, String category, Date createddate,Date latestdate) {
		super();
		
		this.title = title;
		this.content = content;
		this.category = category;
		this.createddate = createddate;
		this.latestdate = latestdate;
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

	public Date getLatestdate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLatestdate(Date latestdate) {
		this.latestdate = latestdate;
	}


	
	
}
