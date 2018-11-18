package com.tor.church.library.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tor.church.library.entity.BookItem;

public interface BookRepository extends MongoRepository<BookItem, String>{
	
	BookItem findByTitle(String title);
	
	List<BookItem> findByPublisher(String publisher);

}
