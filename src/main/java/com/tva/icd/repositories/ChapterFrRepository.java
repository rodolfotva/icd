package com.tva.icd.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tva.icd.model.ChapterFr;

@Repository
public interface ChapterFrRepository extends MongoRepository<ChapterFr, String> {

	@Query("{'id':?0}")
	ChapterFr findByid(String id);

}
