package com.fsd2425.Autowiring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AutowiringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cn=SpringApplication.run(AutowiringApplication.class, args);
		Student S1=(cn.getBean(Student.class));
		System.out.println("Hello");
		System.out.println(S1);
		System.out.println(S1.hashCode());
		
		Student S2=(cn.getBean(Student.class));
		System.out.println("Hello");
		System.out.println(S2);
		System.out.println(S2.hashCode());
	}

}
