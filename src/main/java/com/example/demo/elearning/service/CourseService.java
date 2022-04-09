package com.example.demo.elearning.service;

import java.util.List;

import com.example.demo.elearning.entity.Course;

 
public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourse(int id);
	public List<Course> getCoursesByTitle(String d); 
	public String add(Course course);
	public String updateByDescription(int id,String d);	
	public String updateByTitle(int id,String d);
	public String updateByCertificate(int id,String d);
	public String delete(int id);

}
