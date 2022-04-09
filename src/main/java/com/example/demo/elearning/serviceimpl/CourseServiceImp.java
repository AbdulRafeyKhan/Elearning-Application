package com.example.demo.elearning.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.elearning.entity.Course;
import com.example.demo.elearning.repository.CourseRepository;
import com.example.demo.elearning.service.CourseService;


@Service
public class CourseServiceImp implements CourseService{
	
	private CourseRepository courseRepository;
	@Autowired
	public CourseServiceImp(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	@Transactional
	public List<Course> getCourses() {
		
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	@Override
	@Transactional
	public Course getCourse(int id) {
		return courseRepository.findId(id);
	}

	@Override
	@Transactional
	public String add(Course course) {
		courseRepository.save(course);
		return "Added";
		
	}


	@Override
	@Transactional
	public String delete(int id) {
		courseRepository.deleteById(id);
		return "Removed";
	}

	@Override
	@Transactional
	public List<Course> getCoursesByTitle(String d) {
		return courseRepository.findByTitle(d);
	}

	@Override
	@Transactional
	public String updateByDescription(int id, String d) {
		courseRepository.updateDescription(id, d);
		return "Updated";

		
	}

	@Override
	@Transactional
	public String updateByTitle(int id, String d) {
		courseRepository.updateTitle(id, d);
		return "updated";
	}

	@Override
	@Transactional
	public String updateByCertificate(int id, String d) {
		courseRepository.updateCertificate(id, d);
		return "updated";
		
	}


}
