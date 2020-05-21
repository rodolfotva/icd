package com.tva.icd.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.tva.icd.model.Chapter;

@Repository
public interface ChapterRepository extends MongoRepository<Chapter, String> {

  @Query("{'id':?0}")
  Chapter findByid(String id);
}
