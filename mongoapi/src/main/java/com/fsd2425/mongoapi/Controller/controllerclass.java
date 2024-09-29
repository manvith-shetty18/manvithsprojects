package com.fsd2425.mongoapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fsd2425.mongoapi.Entity.books;
import com.fsd2425.mongoapi.service.bookservice;

@RestController
public class controllerclass {

    @Autowired
    private bookservice s;

    @GetMapping("/")
    public String display(){
        return "Welcome";
    }

    @GetMapping("/list")
    public ResponseEntity<?> getbookslist(){
        return s.getallbooks(); 
    }

    @DeleteMapping ("/del/{isbn}")
    public ResponseEntity<?> deletebooks(@PathVariable String isbn) {
        return s.deletebooks(isbn); 
    }

    @PostMapping ("/lists")
    public ResponseEntity<?> insertbooks(@RequestBody books b){
        return s.insertbooks(b);
    }

    @PutMapping ("/lists")
    public ResponseEntity<?> updatebooks(@RequestBody books b){
        return s.updatebooks(b);
    }
}
