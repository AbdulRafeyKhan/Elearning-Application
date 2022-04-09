package com.example.demo.elearning.serviceimpl;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.demo.elearning.entity.Comment;
import com.example.demo.elearning.entity.Course;
import com.example.demo.elearning.entity.Topics;
import com.example.demo.elearning.repository.CommentRepository;
import com.example.demo.elearning.repository.CourseRepository;
import com.example.demo.elearning.repository.TopicsRepository;
import com.example.demo.elearning.service.CommentService;

@Service
public class CommentServiceImp implements CommentService{
	
	private CourseRepository courseRepository;
	private CommentRepository commentRepository;
	private TopicsRepository topicRepository;

	public CommentServiceImp(CourseRepository courseRepository, CommentRepository commentRepository,TopicsRepository topicRepository) {
		this.courseRepository = courseRepository;
		this.commentRepository = commentRepository;
		this.topicRepository = topicRepository;
	}

	@Override
	public List<Comment> getComments(int id,int id1) {
		Course course=courseRepository.findId(id);
		Topics topic=course.getTopic(course, id1);
		return topic.getComment();
	}

	@Override
	public Comment getComment(int id,int id1,int id2) {
		Course course=courseRepository.findId(id);
		Topics topic=course.getTopic(course, id1);
		 return topic.getCommentById(topic, id2);
		
	}
	@Modifying
	@Override
	public String add(int id,int id1,Comment comment) {
		Course course=courseRepository.findId(id);
		Topics topic=course.getTopic(course, id1);
		topic.addComment(topic, comment);
		topicRepository.save(topic);
		return "Added";
	}

	@Override
	public String delete(int id2) {
		commentRepository.deleteById(id2);
		return "Deleted";
	}


}
