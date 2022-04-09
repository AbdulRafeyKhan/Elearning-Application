package com.example.demo.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.elearning.entity.Course;



@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>  {
	
	@Query("Select c from Course c where c.title like %?1%")
	List<Course> findByTitle(String title);

	@Query("Select c from Course c where c.id = ?1")
	Course findId(int d);
	
	@Modifying
	@Query("UPDATE Course SET description=?2 WHERE id=?1")
	void updateDescription(int id,String d);
	
	@Modifying
	@Query("UPDATE Course SET title=?2 WHERE id=?1")
	void updateTitle(int id, String d);
	
	@Modifying
	@Query("UPDATE Course SET certificate=?2 WHERE id=?1")
	void updateCertificate(int id, String d);

}
