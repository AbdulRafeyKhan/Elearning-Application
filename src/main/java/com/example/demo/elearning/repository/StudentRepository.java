package com.example.demo.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.elearning.entity.Mentor;
import com.example.demo.elearning.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

	@Query("Select m from Student m where m.id = ?1")
	Student findId(int d);

	@Modifying
	@Query("UPDATE Student SET email=?2 WHERE id=?1")
	void updateemail(int id,String d);
	
	@Modifying
	@Query("UPDATE Student SET password=?2 WHERE id=?1")
	void updatepassword(int id,String d);

}
