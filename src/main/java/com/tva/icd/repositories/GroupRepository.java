package com.tva.icd.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.tva.icd.model.Group;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {

  @Query("{'id':?0}")
  Group findByid(String id);

  @Query("{'desc':{$regex:?0}}")
  List<Group> findByDescription(String description);

  @Query("{'name':{$regex:?0}}")
  List<Group> findByName(String name);

  @Query("{'catId':?0}")
  List<Group> findByCategoryid(String catId);

  @Query("{'subGroups.name':?0}")
  Group findSubGroup(String subGrpName);

  @Query("{'subGroups.desc':{$regex:?0}}")
  List<Group> findLikeSubGroupDesc(String subGrpDesc);

}
