package com.example.demo.elearning.service;

import java.util.List;

import com.example.demo.elearning.entity.Course;
import com.example.demo.elearning.entity.Mentor;

public interface MentorService {

	public List<Mentor> getMentors();
	public Mentor getMentor(int id); 
	public String add(Mentor mentor);
	public String addCourse(int id,Course course);
	public String updateByEmail(int id,String d);	
	public String updateByPassword(int id,String d);
	public String delete(int id);
	
}
