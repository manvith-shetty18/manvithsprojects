package com.fsd2425.Restdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2425.Restdemo.Service.Serv;

@RestController
public class Ctrlcls {
	@Autowired
	private Serv service;
	@GetMapping("/")
	public String grt() {
		return ("Welcome to springboot");
	}
    @GetMapping("/greet")
    public String grtusr() {
    	return service.greetuser();
    }
    @GetMapping("/{x}/{y}/{op}")
    public String docalc(@PathVariable int x,
    		             @PathVariable int y,
    		             @PathVariable String op) {
    	return service.calculations(x, y, op);
    }
   
}


