package com.tva.icd.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.tva.icd.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

  @Query("{'id':?0}")
  Category findByid(String id);

  @Query("{'chId':?0}")
  List<Category> findByChapterid(String chId);

}
