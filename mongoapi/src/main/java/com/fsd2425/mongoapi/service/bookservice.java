package com.fsd2425.mongoapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fsd2425.mongoapi.Entity.books;
import com.fsd2425.mongoapi.Repository.repoclass;
import com.mongodb.MongoException;

@Service
public class bookservice {
	
		@Autowired
		private repoclass repo;
		
		public  ResponseEntity<String> load(){
			return ResponseEntity.ok("Welcome to MongoDb Crud Demo...");
		}
		
		public  ResponseEntity<?> getallbooks(){
			List<books> booklist=repo.findAll();
			if (booklist.isEmpty()){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Books Found");
			}
			else {
				return ResponseEntity.ok(booklist);
			}
		}
		
	    public  ResponseEntity<?> insertbooks(books b){
	    	List<books> booklist=new ArrayList<books>();
	    	String err_msg="";
	    	try {
	    		repo.save(b);
	    	}
	    	catch(MongoException e) {
	    		err_msg=e.getMessage();
	    		return ResponseEntity.internalServerError().body(err_msg);
	    	}
	    	booklist=repo.findAll();
			if (booklist.isEmpty()){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Books Found");
			}
			else {
				return ResponseEntity.ok(booklist);
			}  	
			
		}
	     
	    public  ResponseEntity<?> updatebooks(books b){
	        Optional<books> existingbook=repo.findByiSBN(b.getIsbn());
	        List<books> updatedbooklist=new ArrayList<>();
	        if (!existingbook.isPresent()) {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specified book with ISBN : "+b.getIsbn()+" not found.");
	        }
	        else {
	        	try{
	        		repo.deleteByiSBN(b.getIsbn());
	        	   	repo.save(b);
	        	    updatedbooklist=repo.findAll();
	        	    return ResponseEntity.ok(updatedbooklist);
	        	}
	        	catch (MongoException e) {
	        		return ResponseEntity.internalServerError().body(e.getMessage());
	        	}
	        }
		
	    }

	    public  ResponseEntity<?> deletebooks(String isbn){
		    List<books> newbooklist=new ArrayList<>(); 
		   
	    	if (repo.existsByiSBN(isbn)) {
	    		try{
	        		repo.deleteByiSBN(isbn);
	        	   	newbooklist=repo.findAll();
	        	    return ResponseEntity.ok(newbooklist);
	        	}
	        	catch (MongoException e) {
	        		return ResponseEntity.internalServerError().body(e.getMessage());
	        	}
	    	}
	    	else {
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specified book with ISBN : "+isbn+" not found.");
	    	}
	    }
	}
