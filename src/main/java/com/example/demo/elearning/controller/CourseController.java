package com.example.demo.elearning.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.elearning.entity.Course;
import com.example.demo.elearning.serviceimpl.CourseServiceImp;

@RestController
public class CourseController {

	private CourseServiceImp courseServiceImp;
	
	
	@Autowired
	public CourseController(CourseServiceImp courseServiceImp) {
		this.courseServiceImp = courseServiceImp;
	}
	
	@GetMapping("/getcourses")
	public List<Course> listCourses() {
		return courseServiceImp.getCourses();
	}
	@GetMapping("/getcourse/{id}")
	public Course listCourse(@PathVariable int id) {
		return courseServiceImp.getCourse(id);
	}
	
	@GetMapping("/search/{d}")
	public List<Course> listByTitle(@PathVariable String d) {
		return courseServiceImp.getCoursesByTitle(d);
	}
	
	@PostMapping("/savecourse")
	public String saveCourse(@RequestBody Course course) {
		courseServiceImp.add(course);
		return "Added";	
	}
	
	@PutMapping("/deletecourse/{id}")
	public String deleteCourse(@PathVariable int id) {
		courseServiceImp.delete(id);
		return "Deleted";
	}
	
	@PostMapping("/updatedescription/{id}")
	public String updateDescription(@PathVariable int id,@RequestBody String d) {
		courseServiceImp.updateByDescription(id, d);	
		return "Updated";
	}
	@PostMapping("/updatetitle/{id}")
	public String updateTitle(@PathVariable int id,@RequestBody String d) {
		courseServiceImp.updateByTitle(id, d);	
		return "Updated";
	}
	@PostMapping("/updatecertificate/{id}")
	public String updateCertificate(@PathVariable int id,@RequestBody String d) {
		courseServiceImp.updateByCertificate(id, d);	
		return "Updated";
	}
	
}



