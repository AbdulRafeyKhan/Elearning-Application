package com.example.demo.elearning.service;

import java.util.List;

import com.example.demo.elearning.entity.Course;
import com.example.demo.elearning.entity.Student;

public interface StudentService {
	
	public List<Student> getSudnts();
	public Student getStudent(int id); 
	public String add(Student student);
	public String addCourse(int id,int id1);
	public String updateByEmail(int id,String d);	
	public String updateByPassword(int id,String d);
	public String delete(int id);

}
