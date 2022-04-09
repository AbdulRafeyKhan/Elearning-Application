package com.example.demo.elearning.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.demo.elearning.entity.Course;
import com.example.demo.elearning.entity.Mentor;
import com.example.demo.elearning.repository.MentorRepository;
import com.example.demo.elearning.service.MentorService;
@Service
public class MentorServiceImp implements MentorService{
	
	private MentorRepository mentorRepository;
	
	@Autowired
	public MentorServiceImp(MentorRepository mentorRepository) {
		this.mentorRepository = mentorRepository;
	}

	@Override
	public List<Mentor> getMentors() {
		List<Mentor> mentors = new ArrayList<>();
		mentorRepository.findAll().forEach(mentors::add);
		return mentors;
		
	}

	@Override
	public Mentor getMentor(int id) {
		return mentorRepository.findId(id);
	}

	@Override
	public String add(Mentor mentor) {
		mentorRepository.save(mentor);
		return "Added";
	}

	@Override
	@Transactional
	public String updateByEmail(int id, String d) {
		mentorRepository.updateemail(id, d);
		return "updated";
	}

	@Override
	@Transactional
	public String updateByPassword(int id, String d) {
		mentorRepository.updatepassword(id, d);
		return "updated";
	}

	@Override
	@Transactional
	public String delete(int id) {
		mentorRepository.deleteById(id);
		return "deleted";
	}

	@Override
	@Transactional
	@Modifying
	public String addCourse(int id, Course course) {
		Mentor mentor=mentorRepository.findId(id);
		mentor.addCourse(mentor, course);
		return null;
	}

}
