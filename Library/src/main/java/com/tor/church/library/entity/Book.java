package com.tor.church.library.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Cat_Collection")
public class Book {
	@Id
	private Long id;
	
	@Indexed(unique=true)
	@Field(value="BOOK_NO")
	private String bookNo;
	
	@Field(value="TITLE")
	private String title;
	
	@Field(value="AUTHOR")
	private String author;
	
	@Field(value="CATEGORY")
	private String category;
	
	@Field(value="COPY")
	private int copy;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCopy() {
		return copy;
	}
	public void setCopy(int copy) {
		this.copy = copy;
	}
	
	 @Override
	    public String toString() {
	        return "Book[id: " +this.id + ", Title:"+this.title+", Author"+ this.author+ ", Category:"+this.category+"]";
	    }
}
