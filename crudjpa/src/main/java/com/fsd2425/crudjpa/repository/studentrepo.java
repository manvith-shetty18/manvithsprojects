package com.fsd2425.crudjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface studentrepo extends JpaRepository <com.fsd2425.crudjpa.entity.student,String>{
	
	@Query(value="select s.regno,s.name,s.sem,d.depname,d.hod "+ 
			   "from student s, department d "+ 
			   "where s.branch=d.depid" , nativeQuery=true)
	public List <Object []> getDetails();

}
