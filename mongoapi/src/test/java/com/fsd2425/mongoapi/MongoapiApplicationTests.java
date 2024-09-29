package com.fsd2425.mongoapi;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.fsd2425.mongoapi.Entity.books;
import com.fsd2425.mongoapi.Repository.repoclass;
import com.fsd2425.mongoapi.service.bookservice;


@SpringBootTest
class MongocrudApplicationTests {
	
	@Autowired
	private repoclass r;
	@Autowired
	private bookservice s;

	@Test
	void contextLoads() {
	    ResponseEntity<String> basic_response=s.load();
	    Assertions.assertEquals(basic_response.getBody(), "Welcome to MongoDb Crud Demo...");
	}
	
	@Test
	void testInsert() {
		books newbook=new books();
		books insertedbook=new books();
		newbook.setIsbn("20CS18");
		newbook.setBookname("PLC Training Kit");
		newbook.setAuthor("Manvith");
		newbook.setPublisher("VPT Publications");
		newbook.setPrice(500);
		s.insertbooks(newbook);
		insertedbook=r.findByiSBN("20CS18").get();
		SoftAssertions checks=new SoftAssertions();
		checks.assertThat(insertedbook.getIsbn()).isEqualTo("20CS18").withFailMessage("isbn mismatch");
		checks.assertThat(insertedbook.getBookname()).isEqualTo("PLC Training Kit").withFailMessage("bookName mismatch");
		checks.assertThat(insertedbook.getAuthor()).isEqualTo("Manvith").withFailMessage("author mismatch");
		checks.assertThat(insertedbook.getPublisher()).isEqualTo("VPT Publications").withFailMessage("publisher mismatch");
		checks.assertThat(insertedbook.getPrice()).isEqualTo(500).withFailMessage("price mismatch");
		checks.assertAll();
		r.deleteByiSBN("20CS18");
	}
	
	@Test
	void testUpdate() {
		books newbook=new books();
		books updation=new books();
		books updated=new books();
		newbook.setIsbn("20CS18");
		newbook.setBookname("PLC Training Kit");
		newbook.setAuthor("Manvith");
		newbook.setPublisher("VPT Publications");
		newbook.setPrice(500);
		r.save(newbook);
		updation.setIsbn("20CS18");
		updation.setBookname("PLC And PCB");
		updation.setAuthor("Manvith Shetty");
		updation.setPublisher("VPT CS Publications");
		updation.setPrice(550);
		s.updatebooks(updation);
		updated=r.findByiSBN("20CS18").get();
		SoftAssertions checks=new SoftAssertions();
		checks.assertThat(updated.getIsbn()).isEqualTo("20CS18").withFailMessage("isbn mismatch");
		checks.assertThat(updated.getBookname()).isEqualTo("PLC And PCB").withFailMessage("bookName not updated");
		checks.assertThat(updated.getAuthor()).isEqualTo("Manvith Shetty").withFailMessage("author not updated");
		checks.assertThat(updated.getPublisher()).isEqualTo("VPT CS Publications").withFailMessage("publisher not updated");
		checks.assertThat(updated.getPrice()).isEqualTo(550).withFailMessage("price not updated");
		checks.assertAll();
		r.deleteByiSBN("20CS18");
		
	}
	
	@Test
	void testDelete() {
		books newbook=new books();
		newbook.setIsbn("20CS18");
		newbook.setBookname("PLC Training Kit");
		newbook.setAuthor("Manvith");
		newbook.setPublisher("VPT Publications");
		newbook.setPrice(500);
		r.save(newbook);
		s.deletebooks("20CS18");
		Assertions.assertEquals(Optional.empty(), r.findByiSBN("20CS18"));		
	}

	@Test
	void testRead() {
		
		int count_before=r.findAll().size();
		books newbook=new books();
		newbook.setIsbn("20CS18");
		newbook.setBookname("PLC Training Kit");
		newbook.setAuthor("Manvith");
		newbook.setPublisher("VPT Publications");
		newbook.setPrice(500);
		r.save(newbook);
		List<books> booklist=r.findAll();
		int count_after=booklist.size();
		Assertions.assertEquals(count_before+1,count_after );
		r.deleteByiSBN("20CS18");
		}
}
