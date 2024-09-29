package com.fsd2425.crudjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2425.crudjpa.Dto.studdetail;
import com.fsd2425.crudjpa.entity.student;
import com.fsd2425.crudjpa.service.Studservice;

@RestController
public class studctrl {
@Autowired
private Studservice s;
@GetMapping("/")
public String display(){
	return "Welcome";
}
@GetMapping("/students")
public List<student> getstudentlist(){
	return s.getallstudents();
}
@DeleteMapping ("/del/{rno}")
public void delstud(@PathVariable String rno) {
	s.deletestudent(rno);
}
@PostMapping ("/student")
public student insertstud(@RequestBody student st){
	return s.insertstudent(st);
}
@PutMapping ("/student")
public student updatestud(@RequestBody student st){
	return s.updatestudent(st);
}
@GetMapping("/details")
private List<studdetail> dispDetails() {
	return s.getStudentDetails();
}
}
