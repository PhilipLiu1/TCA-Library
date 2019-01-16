package com.tor.church.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tor.church.library.entity.BookItem;
import com.tor.church.library.entity.BorrowRecord;
import com.tor.church.library.entity.Client;
import com.tor.church.library.repository.BookRepository;
import com.tor.church.library.repository.BorrowRecordRepository;
import com.tor.church.library.repository.ClientRepository;
import com.tor.church.library.repository.CustomRepository;
import com.tor.church.library.repository.FindBookRepository;

@Controller
public class MainController {
   
	 @Autowired
	 private BookRepository bookRepository;
	 @Autowired
	 private CustomRepository custRepository;
	 @Autowired
	 private FindBookRepository findRepository;
	 @Autowired
	 private ClientRepository clientRepository;
	 @Autowired
	 private BorrowRecordRepository brRepository;
	 
	 @Value("${BORROW_DAYS}")
	 private int borrowDays;
	 
	 @RequestMapping("/")
	    public String echoTheUsersEmailAddress(Principal principal) {
/*		 
		 if(null != principal) {
	        System.out.println("The login user email address is: " + principal.getName());
	        return "index";
		 }else {
			 return "redirect:login";
		 }
*/
		 return "index";
	    }
	    
	   @RequestMapping(value = "/locale")
	   public String getLocalePage(Model model) {
		   
	       return "index";
	   }

	   
/*Book related operations */	   
	    @RequestMapping("/showAllBooks")
	    public String showAllBooks(Model model) {
	 
	        List<BookItem> books = this.bookRepository.findAll();
	        model.addAttribute("books", books);
	        return "bookList";
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
	        return "bookList";
	    }
	    
       @RequestMapping("/searchByCriteria")
       public String searchByCriteria(Model model, @RequestParam Map<String, String> reqParams) {
    	   
    	    String genCriteria = reqParams.get("criteria");
    	    String searchAuthor = reqParams.get("searchAuthor");
    	    String searchTitle = reqParams.get("searchTitle");
    	    String searchSubject = reqParams.get("searchSubject");
    	    String searchDewey = reqParams.get("searchDewey");
    	    
    	    if (null != searchAuthor) {
     	    	model.addAttribute("books", findRepository.findByAuthorContaining(genCriteria));
    	    }else if (null != searchTitle) {
     	    	model.addAttribute("books", findRepository.findByTitleContaining(genCriteria));
    	    }else if (null != searchSubject) {
     	    	model.addAttribute("books", findRepository.findBySubjectHeadingContaining(genCriteria));
    	    }else if (null != searchDewey) {
     	    	model.addAttribute("books", findRepository.findByDeweyContaining(genCriteria));
    	    }else {
     	    	model.addAttribute("books", findRepository.findAll());
    	    	
    	    }

    	    return "bookList";    	   
       }
	    
/* Client related operations */
		@RequestMapping("/showAllClients")
	    public String showAllClients(Model model) {
	    	model.addAttribute("clients", clientRepository.findAll());
	        return "clientList";
	    }
		
	    @RequestMapping("/clientDetails")
	    public String showClientDetails(@RequestParam (name="custId", required=false) String custID, Model model) {
	 
	        Optional<Client> aClient = this.clientRepository.findById(custID);

	        Client client = new Client();
	        if(aClient.isPresent()) {
	        	client = aClient.get();
	        }
	        	        
	        model.addAttribute("client", client);
	        return "clientDetails";
	    }		
		       
	    @RequestMapping("/addClient")
	    public String addClient() {
	        return "addClient";
	    }
	    
	    @RequestMapping("/deleteClient")
	    public String deleteClient(@RequestParam (name="clientId", required=false) String clientID, Model model) {

	        clientRepository.deleteById(clientID);
	        
	        return this.showAllClients(model);
	    }
	    
	    @RequestMapping("/saveAddClient")
	    public String saveAddClient(@ModelAttribute("aClient") Client aClient, Model model) {
	  
	        clientRepository.insert(aClient);
	        
	        return this.showAllClients(model);
	    }
	    
	    @RequestMapping("/updateClient")
	    public String updateClient(@RequestParam (name="clientId", required=false) String clientID, Model model) {
	 
	        Optional<Client> aClient = this.clientRepository.findById(clientID);
	       
	        Client client = new Client();
	        if(aClient.isPresent()) {
	        	client = aClient.get();
	        }
	        
	        model.addAttribute("client", client);
	        return "updateClient";
	    } 
	    

	    @RequestMapping("/saveUpdateClient")
	    public String saveUpdateClient(@ModelAttribute("client") Client aClient, Model model) {
	  
	        clientRepository.save(aClient);
	        
	        model.addAttribute("client", aClient);
	        return "clientDetails";
	    }	
	    
/*Borrow related operations*/
	    @RequestMapping("/borrowBook")
	    public String borrowBook(@RequestParam (name="bookId", required=false) String bookID, Model model) {
	  	     
	        model.addAttribute("bookID", bookID);
	        model.addAttribute("clients", clientRepository.findAll());
	        model.addAttribute("client", new Client());
	        
	        return "borrowBook";
	    }	 
	    
		 
	    @RequestMapping("/showAllBorrows")
	    public String showAllBorrows(Model model) {
	 
	        List<BorrowRecord> brws = this.brRepository.findAll();
	        brws.forEach(brw ->{
	        	BookItem book = brw.getBook();
	        	Client client = brw.getClient();
	        	System.out.println("Book Id: "+ book.getId());
	        	System.out.println("Client Id:" + client.getId());
	        });
	        
	        model.addAttribute("brws", brws);
	        return "borrowList";
	    }	    
	    
	    @RequestMapping("/saveBorrowBook")
	    public String saveBorrowBook(@RequestParam Map<String,String> allRequestParams, Model model) {
	  	     
	    	String bookId = allRequestParams.get("bookId");
	    	String clientId = allRequestParams.get("id");
	    	
	        Optional<Client> aClient = this.clientRepository.findById(clientId);
	    	
	        Client client = new Client();
	        if(aClient.isPresent()) {
	        	client = aClient.get();
	        }else {
	        	System.out.println("Client not found!");
	        }
	        
	        Optional<BookItem> aBook = this.bookRepository.findById(bookId);
		       
	        BookItem book = new BookItem();
	        if(aBook.isPresent()) {
	        	book = aBook.get();
	        }else {
	        	System.out.println("Book not found!");
	        }
	        	        
	        model.addAttribute("client", client);
	        
	        Date today = new Date();
	        Date returnDate = Date.from(LocalDate.now().plusDays(this.borrowDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	        
	        BorrowRecord br = new BorrowRecord();
	        br.setBook(book);
	        br.setClient(client);
	        br.setStartDate(today);
	        br.setRenewTimes(0);
	        br.setIsExpired(false);
	        br.setExpectedReturnDate(returnDate);
	        br.setRenewTimes(0);
	        br.setReturnedFlag(false);

	        this.brRepository.save(br);
	        
	        return this.showAllBorrows(model);
	        
	    }	 
	    
	    @RequestMapping("/borrowDetails")
	    public String showBorrowDetails(@RequestParam (name="brwId", required=false) String brwID, Model model) {
	 
	        Optional<BorrowRecord> aBrw = this.brRepository.findById(brwID);

	        BorrowRecord brw = new BorrowRecord();
	        if(aBrw.isPresent()) {
	        	brw = aBrw.get();
	        }
	        	        
	        model.addAttribute("brw", brw);
	        return "borrowDetails";
	    }
	    
	    @RequestMapping("/updateBorrow")
	    public String updateBorrow(@RequestParam (name="brwId", required=false) String brwID, Model model) {
	 
	        Optional<BorrowRecord> aBrw = this.brRepository.findById(brwID);

	        BorrowRecord brw = new BorrowRecord();
	        if(aBrw.isPresent()) {
	        	brw = aBrw.get();
	        }
	        	        
	        model.addAttribute("brw", brw);
	        return "updateBorrow";
	    } 	    
	    
	    @RequestMapping("/saveUpdateBorrow")
	    public String saveUpdateBorrow(@RequestParam Map<String,String> allRequestParams, @ModelAttribute("aBrw") BorrowRecord aBrw,  Model model) {
	  
	    	String bookId = allRequestParams.get("bookId");
	    	String clientId = allRequestParams.get("clientId");
	    	
	        Optional<Client> aClient = this.clientRepository.findById(clientId);
	    	
	        Client client = new Client();
	        if(aClient.isPresent()) {
	        	client = aClient.get();
	        }else {
	        	System.out.println("Client not found!");
	        }
	        
	        Optional<BookItem> aBook = this.bookRepository.findById(bookId);
		       
	        BookItem book = new BookItem();
	        if(aBook.isPresent()) {
	        	book = aBook.get();
	        }else {
	        	System.out.println("Book not found!");
	        }
	        
	        aBrw.setBook(book);
	        aBrw.setClient(client);
	        
	        brRepository.save(aBrw);
	        
	        model.addAttribute("brw", aBrw);
	        return "borrowDetails";
	    }		    
}
