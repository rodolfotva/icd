package com.tva.icd.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tva.icd.model.GroupFr;

@Repository
public interface GroupFrRepository extends MongoRepository<GroupFr, String> {

	@Query("{'id':?0}")
	GroupFr findByid(String id);

	@Query("{'desc':{$regex:?0}}")
	List<GroupFr> findByDescription(String description);

	@Query("{'name':{$regex:?0}}")
	List<GroupFr> findByName(String name);

	@Query("{'catId':?0}")
	List<GroupFr> findByCategoryid(String catId);

	@Query("{'subGroups.name':?0}")
	GroupFr findSubGroup(String subGrpName);

	@Query("{'subGroups.desc':{$regex:?0}}")
	List<GroupFr> findLikeSubGroupDesc(String subGrpDesc);

}
