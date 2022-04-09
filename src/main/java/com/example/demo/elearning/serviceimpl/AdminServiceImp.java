package com.example.demo.elearning.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.elearning.entity.Course;
import com.example.demo.elearning.entity.Mentor;
import com.example.demo.elearning.entity.Student;
import com.example.demo.elearning.repository.CourseRepository;
import com.example.demo.elearning.repository.MentorRepository;
import com.example.demo.elearning.repository.StudentRepository;

@Service
public class AdminServiceImp {
	
	private CourseRepository courseRepository;
	private StudentRepository studentRepository;
	private MentorRepository mentorRepository;
	
	@Autowired
	public AdminServiceImp(CourseRepository courseRepository, StudentRepository studentRepository,MentorRepository mentorRepository) {
		this.courseRepository = courseRepository;
		this.studentRepository = studentRepository;
		this.mentorRepository = mentorRepository;
	}
	
	public String  count()
	{
		long c= courseRepository.count();
		long s=studentRepository.count();
		long m= mentorRepository.count();
		return "Stats [Total Courses = " + c + ", Total Students = " + s + ", Total Mentors = " + m + "]";
	}

	public List<String> getStudents()
	{
		List<String> s=new ArrayList<String>();
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		for(Student t:students)
		{
			s.add(t.toString());
		}
		return s;	
	}
	public List<String> getCourses()
	{
		List<String> s=new ArrayList();
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		for(Course t:courses)
		{
			s.add(t.toString());
		}
		return s;	
	}
	public List<String> getmentors()
	{
		List<String> s=new ArrayList();
		List<Mentor> mentors = new ArrayList<>();
		mentorRepository.findAll().forEach(mentors::add);
		for(Mentor t:mentors)
		{
			s.add(t.toString());
		}
		return s;	
	}
	
	

}
