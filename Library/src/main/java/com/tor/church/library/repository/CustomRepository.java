package com.tor.church.library.repository;

import java.util.List;

import com.tor.church.library.entity.BookItem;

public interface CustomRepository {
	
	//public String getMaxBookId();
	public BookItem updateBook(BookItem book);
    public void insertBook(BookItem book);
    public void deleteBook(BookItem book);
    public List<BookItem> searchBooks(String text);
}
