package com.fsd2425.exmdem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2425.exmdem.service.servesobj;

@RestController
public class ctrlobj {
	@Autowired 
	private servesobj service;
	
	@GetMapping("/")
	public String display() {
		return  ("welcome to cie4");
	}
	
	@GetMapping("/{circle}/{x}")
	public String cirusr(@PathVariable int x,
				         @PathVariable String circle) {
		return service.calculations(x,circle);
}
	@GetMapping("/{rectangle}/{y}/{z}")
	public String rectusr(@PathVariable int z,
				          @PathVariable int y,
				          @PathVariable String rectangle) {
				return service.calculators(z,y,rectangle) ;
}
	}
	
