package com.fsd2425.mongoapi.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.fsd2425.mongoapi.Entity.books;

@Repository

public interface repoclass extends MongoRepository<books,String>{
	public List<books> deleteByiSBN(String iSBN); 
    public Optional<books> findByiSBN(String iSBN);
    public boolean existsByiSBN(String iSBN);
	}
