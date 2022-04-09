package com.example.demo.elearning.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.elearning.serviceimpl.AdminServiceImp;
import com.example.demo.elearning.serviceimpl.CourseServiceImp;
import com.example.demo.elearning.serviceimpl.MentorServiceImp;
import com.example.demo.elearning.serviceimpl.StudentServiceImp;

@RestController
public class AdminController {
	
	private CourseServiceImp courseServiceImp;
	private StudentServiceImp studentServiceImp;
	private MentorServiceImp  mentorServiceImp;
	private AdminServiceImp adminServiceImp;
	
	
	public AdminController(CourseServiceImp courseServiceImp, StudentServiceImp studentServiceImp,
			MentorServiceImp mentorServiceImp, AdminServiceImp adminServiceImp) {
		this.courseServiceImp = courseServiceImp;
		this.studentServiceImp = studentServiceImp;
		this.mentorServiceImp = mentorServiceImp;
		this.adminServiceImp=adminServiceImp;
	}
	@GetMapping("/adminpage")
	public String adminPage()
	{
		return adminServiceImp.count();
	}
	@GetMapping("/adminstudents")
	public List<String> getStudents()
	{
		return adminServiceImp.getStudents();
	}
	@GetMapping("/adminmentors")
	public List<String> getMentors()
	{
		return adminServiceImp.getmentors();
	}
	@GetMapping("/admincourses")
	public List<String> getCourses()
	{
		return adminServiceImp.getCourses();
	}
	
	@PutMapping("/admindeletecourse/{id}")
	public String deleteCourse(@PathVariable int id) {
		courseServiceImp.delete(id);
		return "Deleted";
		
	}
	@PutMapping("/admindeletestudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentServiceImp.delete(id);
		return "Deleted";
		
	}
	@PutMapping("/admindeletementor/{id}")
	public String deleteMentor(@PathVariable int id) {
		mentorServiceImp.delete(id);
		return "Deleted";
		
	}

}
