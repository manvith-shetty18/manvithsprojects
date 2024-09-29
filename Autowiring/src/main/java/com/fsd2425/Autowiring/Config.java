package com.fsd2425.Autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
	@Bean (name="add1")
	public Address add1(){
		return new Address ("Nagara","Puttur","574203");
		
	}
	@Bean (name="add2")
	public Address add2(){
		return new Address ("kedila","Puttur","574206");
		
	}

	@Bean (name="add3")
	public Address add3(){
		return new Address ("kabaka","Puttur");
		
	}
	
	@Bean
	@Primary
	public classstudying cls() {
		return new classstudying(5,"cs");
	}
	
	@Bean
	@Scope("singleton")
	public Student student() { 
		return new Student ("391CS2018","Manvith");
	}
	


}
