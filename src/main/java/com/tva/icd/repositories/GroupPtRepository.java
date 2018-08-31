package com.tva.icd.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tva.icd.model.GroupPt;

@Repository
public interface GroupPtRepository extends MongoRepository<GroupPt, String> {

	@Query("{'id':?0}")
	GroupPt findByid(String id);

	@Query("{'desc':{$regex:?0}}")
	List<GroupPt> findByDescription(String description);

	@Query("{'name':{$regex:?0}}")
	List<GroupPt> findByName(String name);

	@Query("{'catId':?0}")
	List<GroupPt> findByCategoryid(String catId);

	@Query("{'subGroups.name':?0}")
	GroupPt findSubGroup(String subGrpName);

	@Query("{'subGroups.desc':{$regex:?0}}")
	List<GroupPt> findLikeSubGroupDesc(String subGrpDesc);

}
