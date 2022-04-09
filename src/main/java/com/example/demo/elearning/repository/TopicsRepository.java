package com.example.demo.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.elearning.entity.Topics;

@Repository
public interface TopicsRepository extends JpaRepository<Topics,Integer> {
	
	@Query("Select t from Topics t where t.id =?1")
	List<Topics> findId(int id);
	
	@Modifying
	@Query("UPDATE Topics SET topic=?2 WHERE id=?1")
	void updateTopic(int id,String d);
	
	@Modifying
	@Query("UPDATE Topics SET path=?2 WHERE id=?1")
	void updatePath(int id,String d);
	
//	
//	@Query("Select c from Topics c where c.title like %?1%")
//	List<Topics> findByTopic(String d);
//	 

}
