package com.tva.icd.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.tva.icd.model.CategoryPt;

@Repository
public interface CategoryPtRepository extends MongoRepository<CategoryPt, String> {

  @Query("{'id':?0}")
  CategoryPt findByid(String id);

  @Query("{'chId':?0}")
  List<CategoryPt> findByChapterid(String chId);

}
