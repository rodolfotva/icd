package com.tva.icd.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.tva.icd.model.ChapterPt;

@Repository
public interface ChapterPtRepository extends MongoRepository<ChapterPt, String> {

  @Query("{'id':?0}")
  ChapterPt findByid(String id);

}
