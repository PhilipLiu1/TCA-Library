package com.tor.church.library.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tor.church.library.entity.BookItem;


public interface FindBookRepository extends PagingAndSortingRepository<BookItem, String> {
	
	List<BookItem> findByTitleContaining(String title);
	List<BookItem> findByAuthorContaining(String author);
	List<BookItem> findBySubjectHeadingContaining(String subjectHeading);
	List<BookItem> findByDeweyContaining(String dewey);

}
