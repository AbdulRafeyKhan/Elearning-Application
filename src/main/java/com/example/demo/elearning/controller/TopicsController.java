package com.example.demo.elearning.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.elearning.entity.Topics;
import com.example.demo.elearning.serviceimpl.TopicsServiceImp;

@RestController
public class TopicsController {
	
	private TopicsServiceImp topicsServiceImp;
	
	
	@Autowired
	public TopicsController(TopicsServiceImp topicsServiceImp) {
		this.topicsServiceImp = topicsServiceImp;
	}
	
	@GetMapping("/gettopics/{id}")
	public List<Topics> listTopics(@PathVariable int id) {
		return topicsServiceImp.getTopics(id);
	}

	@PostMapping("/addtopic/{id}")
	public String addTopic(@PathVariable int id, @RequestBody Topics topics) {
		topicsServiceImp.add(id,topics);
		return "Added";
	}
	@GetMapping("/gettopic/{id}/{id1}")
	public Topics listCourse(@PathVariable int id,@PathVariable int id1) {
		return topicsServiceImp.getTopic(id, id1);
	}
	@PutMapping("/deletetopic/{id}")
	public String deleteCourse(@PathVariable int id) {
		topicsServiceImp.delete(id);
		return "Deleted";
	}
	@PostMapping("/updatetopic/{id}")
	public String updateTopic(@PathVariable int id,@RequestBody String d) {
		topicsServiceImp.updateByTopic(id, d);
		return "Updated";
	}
	
	@PostMapping("/updatepath/{id}")
	public String updatePath(@PathVariable int id,@RequestBody String d){
		topicsServiceImp.updateByPath(id, d);
		return "Updated";
	}

}
