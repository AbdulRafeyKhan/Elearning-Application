package com.example.demo.elearning.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.demo.elearning.entity.Course;
import com.example.demo.elearning.entity.Student;
import com.example.demo.elearning.repository.CourseRepository;
import com.example.demo.elearning.repository.StudentRepository;
import com.example.demo.elearning.service.StudentService;
@Service
public class StudentServiceImp implements StudentService{
	
	private StudentRepository studentRepository;
	private CourseRepository courseRepository ;

	@Autowired
	public StudentServiceImp(StudentRepository studentRepository, CourseRepository courseRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}


	@Override
	public List<Student> getSudnts() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}

	@Override
	public Student getStudent(int id) {
		return studentRepository.findId(id);
		 
	}

	@Override
	public String add(Student student) {
		studentRepository.save(student);
		return null;
	}

	@Override
	@Transactional
	public String updateByEmail(int id, String d) {
		studentRepository.updateemail(id, d);
		return null;
	}

	@Override
	@Transactional
	public String updateByPassword(int id, String d) {
		studentRepository.updatepassword(id, d);
		return null;
	}

	@Override
	public String delete(int id) {
		studentRepository.deleteById(id);
		return null;
	}

	@Override
	@Transactional
	@Modifying
	public String addCourse(int id,int id1) {
		Student student=studentRepository.findId(id);
		Course course=courseRepository.findId(id1);
		student.addCourse(student, course);
		return "enrolled";
	}

}
