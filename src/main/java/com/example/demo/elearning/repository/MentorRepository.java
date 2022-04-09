package com.example.demo.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.elearning.entity.Mentor;
@Repository
public interface MentorRepository extends JpaRepository<Mentor,Integer>  {
	
	@Query("Select m from Mentor m where m.id = ?1")
	Mentor findId(int d);

	@Modifying
	@Query("UPDATE Mentor SET email=?2 WHERE id=?1")
	void updateemail(int id,String d);
	
	@Modifying
	@Query("UPDATE Mentor SET password=?2 WHERE id=?1")
	void updatepassword(int id,String d);
}
