package com.example.demo.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.elearning.entity.Course;
import com.example.demo.elearning.entity.Student;
import com.example.demo.elearning.serviceimpl.StudentServiceImp;
@RestController
public class StudentController {
	
	private StudentServiceImp studentServiceImp;
	@Autowired
	public StudentController(StudentServiceImp studentServiceImp) {
		this.studentServiceImp = studentServiceImp;
	}
	
	@GetMapping("/getstudents")
	public List<Student> getstudents() {
		return studentServiceImp.getSudnts();
	}
	
	@GetMapping("/getstudent/{d}")
	public Student getStudent(@PathVariable int id) {
		return studentServiceImp.getStudent(id);
	}
	
	@PostMapping("/savestudent")
	public String saveStudent(@RequestBody Student student) {
		studentServiceImp.add(student);
		return "Added";	
	}
	
	@PostMapping("/enrollcourse/{id}/{id1}")
	public String enrollCourse(@PathVariable int id,@PathVariable int id1) {
		studentServiceImp.addCourse(id,id1);
		return "Added";	
	}
	@PostMapping("/updatestudentemail/{id}")
	public String updateemail(@PathVariable int id,@RequestBody String d) {
		studentServiceImp.updateByEmail(id, d);	
		return "Updated";
	}
	@PostMapping("/updatestudentpassword/{id}")
	public String updatepassword(@PathVariable int id,@RequestBody String d) {
		studentServiceImp.updateByPassword(id, d);	
		return "Updated";
	}

	@PutMapping("/deletestudent/{id}")
	public String deleteCourse(@PathVariable int id) {
		studentServiceImp.delete(id);
		return "Deleted";
	}
	
}
