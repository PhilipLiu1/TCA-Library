package com.tor.church.library.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="TCA_COL")
public class BookItem {
	@Id
	@Field(value="_id")
	private String id;
	
	@Field(value="class")
	@TextIndexed
	private String classes;
	
	@Field(value="dewey")
	@TextIndexed
	private String dewey;
	
	@Field(value="publisher")
	@TextIndexed
	private String publisher;
	
	@Field(value="title")
	@TextIndexed
	private String title;

	@Field(value="isbn")
	private String isbn;
	
	@Field(value="vol")
	private String vol;

	@Field(value="author")
	@TextIndexed
	private String author;
	
	@Field(value="series")
	private String series;
	
	@Field(value="subject_heading")
	@TextIndexed
	private String subject_heading;
	
	@Field(value="subject_heading_1")
	private String subject_heading_1;

	@Field(value="remarks")
	private String remarks;
	
	@Field(value="remarks1")
	private String remarks1;
	
	@Field(value="edition")
	private String edition;
	
	@Field(value="year")
	private String year;
	
	@Field(value="entrydate")
	@TextIndexed
	private String entryDate;
	
	

	
	 @Override
	    public String toString() {
	        return "BookItem [id: " +this.id + ", Title:"+this.title+", Author"+ this.author+ "]";
	    }




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getDewey() {
		return dewey;
	}




	public void setDewey(String dewey) {
		this.dewey = dewey;
	}




	public String getPublisher() {
		return publisher;
	}




	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getAuthor() {
		return author;
	}




	public void setAuthor(String author) {
		this.author = author;
	}




	public String getSeries() {
		return series;
	}




	public void setSeries(String series) {
		this.series = series;
	}




	public String getSubject_heading() {
		return subject_heading;
	}




	public void setSubject_heading(String subject_heading) {
		this.subject_heading = subject_heading;
	}




	public String getYear() {
		return year;
	}




	public void setYear(String year) {
		this.year = year;
	}




	public String getClasses() {
		return classes;
	}




	public void setClasses(String classes) {
		this.classes = classes;
	}




	public String getIsbn() {
		return isbn;
	}




	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}




	public String getVol() {
		return vol;
	}




	public void setVol(String vol) {
		this.vol = vol;
	}




	public String getSubject_heading_1() {
		return subject_heading_1;
	}




	public void setSubject_heading_1(String subject_heading_1) {
		this.subject_heading_1 = subject_heading_1;
	}




	public String getRemarks() {
		return remarks;
	}




	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}




	public String getRemarks1() {
		return remarks1;
	}




	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}




	public String getEdition() {
		return edition;
	}




	public void setEdition(String edition) {
		this.edition = edition;
	}




	public String getEntryDate() {
		return entryDate;
	}




	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
}
