package com.tva.icd.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.tva.icd.model.CategoryFr;

@Repository
public interface CategoryFrRepository extends MongoRepository<CategoryFr, String> {

  @Query("{'id':?0}")
  CategoryFr findByid(String id);

  @Query("{'chId':?0}")
  List<CategoryFr> findByChapterid(String chId);

}
