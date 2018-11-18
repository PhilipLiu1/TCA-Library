package com.tor.church.library.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;
import com.tor.church.library.entity.BookItem;

@Repository
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
/*	@Override
	public String getMaxBookId() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        query.limit(1);
        BookItem maxObject = mongoTemplate.findOne(query, BookItem.class);
        if (maxObject == null) {
            return "Not found";
        }
        return maxObject.getId();
       // return 0L;
	}*/

	@Override
	public BookItem updateBook(BookItem book) {
		
        Query query = new Query(Criteria.where("_id").is(book.getId()));
        Update update = new Update();
        update.set("classes", book.getClasses());
        update.set("author", book.getAuthor());
        update.set("dewey", book.getDewey());
        update.set("publisher", book.getPublisher());
        update.set("title", book.getTitle());
        update.set("edition", book.getEdition());
        update.set("isbn", book.getIsbn());
        update.set("remarks", book.getRemarks());
        update.set("remarks1", book.getRemarks1());
        update.set("series", book.getSeries());
        update.set("subject_heading", book.getSubject_heading());
        update.set("subject_heading_1", book.getSubject_heading_1());
         
        BookItem result = this.mongoTemplate.findAndModify(query, update, BookItem.class);
 
        if (result != null) {
        	System.out.println("Updated book:"+ result.toString());
            return result;
        }else {
        	System.out.println("Updated book failed!");
            return null;
        }
 
	}
	
	@Override
	public void insertBook(BookItem book) {
		mongoTemplate.insert(book);
		System.out.println("Inserted a book");
	}
	
	@Override
	public void deleteBook(BookItem book) {
		DeleteResult result = mongoTemplate.remove(book);
		System.out.println("Deleted book number: d%"+ result.getDeletedCount());
	}
	
    @Override
	public List<BookItem> searchBooks(String text) {
        return mongoTemplate.find(Query.query(new Criteria()
                        .orOperator(Criteria.where("title").regex(text, "i"),
                                    Criteria.where("classes").regex(text, "i"),
                                    Criteria.where("publisher").regex(text, "i"),
                                    Criteria.where("dewey").regex(text, "i"),
                                    Criteria.where("subject_heading").regex(text, "i"),
                                    Criteria.where("entrydate").regex(text, "i"),
                                    Criteria.where("author").regex(text, "i"))
                        ), BookItem.class);
    }
}
