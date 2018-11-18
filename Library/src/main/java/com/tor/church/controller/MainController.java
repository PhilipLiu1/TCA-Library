package com.tor.church.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tor.church.library.entity.BookItem;
import com.tor.church.library.repository.BookRepository;
import com.tor.church.library.repository.CustomRepository;

@Controller
public class MainController {
   
	 @Autowired
	 private BookRepository bookRepository;
	 @Autowired
	 private CustomRepository custRepository;
	 
	 @RequestMapping("/")
	    public String echoTheUsersEmailAddress(Principal principal) {
		 
		 if(null != principal) {
	        System.out.println("The login user email address is: " + principal.getName());
	        return "index";
		 }else {
			 return "redirect:login";
		 }
	    }
	    
	   @RequestMapping(value = "/locale", method = RequestMethod.GET)
	   public String getLocalePage(Model model) {
	       return this.showAllBooks(model);
	   }
	 
	 
	    @RequestMapping("/showAllBooks")
	    public String showAllBooks(Model model) {
	 
	        List<BookItem> books = this.bookRepository.findAll();
	 
        
	        model.addAttribute("books", books);
	        return "booklist";
	    }
	    
	    @RequestMapping("/bookDetails")
	    public String showBookDetails(@RequestParam (name="bookId", required=false) String bookID, Model model) {
	 
	        Optional<BookItem> aBook = this.bookRepository.findById(bookID);
	       
	        BookItem book = new BookItem();
	        if(aBook.isPresent()) {
	        	book = aBook.get();
	        }
	        
        
	        model.addAttribute("book", book);
	        return "bookDetails";
	    }

	    @RequestMapping("/updateBook")
	    public String updateBook(@RequestParam (name="bookId", required=false) String bookID, Model model) {
	 
	        Optional<BookItem> aBook = this.bookRepository.findById(bookID);
	       
	        BookItem book = new BookItem();
	        if(aBook.isPresent()) {
	        	book = aBook.get();
	        }
	        
	        model.addAttribute("book", book);
	        return "updateBook";
	    } 
	    

	    @RequestMapping("/saveUpdateBook")
	    public String saveUpdate(@ModelAttribute("aBook") BookItem aBook, Model model) {
	  
	        custRepository.updateBook(aBook);
	        
	        model.addAttribute("book", aBook);
	        return "bookDetails";
	    }

	    @RequestMapping("/insertBook")
	    public String insertBook() {
	        return "insertBook";
	    }

	    @RequestMapping("/saveInsertBook")
	    public String saveInsert(@ModelAttribute("aBook") BookItem aBook, Model model) {
	  
	        custRepository.insertBook(aBook);
	        
	        return showAllBooks(model);
	    }
	    
	    @RequestMapping("/deleteBook")
	    public String deleteBook(@RequestParam (name="bookId", required=false) String bookID, Model model) {

	        Optional<BookItem> aBook = this.bookRepository.findById(bookID);
		       
	        BookItem book = new BookItem();
	        if(aBook.isPresent()) {
	        	book = aBook.get();
	        }
	    	
	        custRepository.deleteBook(book);
	        
	        return this.showAllBooks(model);
	    }
	    	    
	    @RequestMapping("/search")
	    public String search(Model model, @RequestParam String search) {
	    	model.addAttribute("books", custRepository.searchBooks(search));
	    	model.addAttribute("searchValue", search);
	        return "booklist";
	    }
	    
	
}
