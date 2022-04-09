package com.example.demo.elearning.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.demo.elearning.entity.Course;
import com.example.demo.elearning.entity.Topics;
import com.example.demo.elearning.repository.CourseRepository;
import com.example.demo.elearning.repository.TopicsRepository;
import com.example.demo.elearning.service.TopicsService;

@Service
public class TopicsServiceImp implements TopicsService {
	
	private TopicsRepository topicsRepository;
	private CourseRepository courseRepository;
	
	
	
	@Autowired
	public TopicsServiceImp(TopicsRepository topicsRepository, CourseRepository courseRepository) {
		this.topicsRepository = topicsRepository;
		this.courseRepository=courseRepository;
	}

	@Override
	public List<Topics> getTopics(int id) {
		Course course = courseRepository.findId(id);
		return course.getTopics();	

	}
	@Modifying
	@Override
	public String add(int id, Topics topics) {
		Course course = courseRepository.findId(id);
		course.addtopic(course, topics);
		courseRepository.save(course);
		return "Added";	
	}

	@Override
	public Topics getTopic(int id , int id1) {
		Course course=courseRepository.findId(id);
		return course.getTopic(course, id1);
	}

	@Override
	@Transactional
	public String delete(int id) {
		topicsRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	@Transactional
	public String updateByTopic(int id, String d) {
		topicsRepository.updateTopic(id, d);
		return "updated";
	}

	@Override
	@Transactional
	public String updateByPath(int id, String d) {
		topicsRepository.updatePath(id, d);
		return "updated";
	}

}
