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
import com.example.demo.elearning.entity.Mentor;
import com.example.demo.elearning.serviceimpl.MentorServiceImp;
@RestController
public class MentorController {
	
	private MentorServiceImp mentorServiceImp;
	
	@Autowired
	public MentorController(MentorServiceImp mentorServiceImp) {
		this.mentorServiceImp = mentorServiceImp;
	}
	
	@GetMapping("/getmentors")
	public List<Mentor> getMentors() {
		return mentorServiceImp.getMentors();
	}

	@GetMapping("/getmentor/{d}")
	public Mentor getMentor(@PathVariable int id) {
		return mentorServiceImp.getMentor(id);
	}
	
	@PostMapping("/savementor")
	public String saveMentor(@RequestBody Mentor mentor) {
		mentorServiceImp.add(mentor);
		return "Added";	
	}
	
	@PostMapping("/uploadcourse/{id}")
	public String upoadCourse(@PathVariable int id,@RequestBody Course course) {
		mentorServiceImp.addCourse(id,course);
		return "Added";	
	}
	@PostMapping("/updatementoremail/{id}")
	public String updateemail(@PathVariable int id,@RequestBody String d) {
		mentorServiceImp.updateByEmail(id, d);
		return "Updated";
	}
	@PostMapping("/updatesmentorpassword/{id}")
	public String updatepassword(@PathVariable int id,@RequestBody String d) {
		mentorServiceImp.updateByPassword(id, d);
		return "Updated";
	}

	@PutMapping("/deletementor/{id}")
	public String deleteCourse(@PathVariable int id) {
		mentorServiceImp.delete(id);
		return "Deleted";
	}

}
