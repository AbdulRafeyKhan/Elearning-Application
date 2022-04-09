package com.example.demo.elearning.service;

import java.util.List;

import com.example.demo.elearning.entity.Topics;


public interface TopicsService {
	
	public List<Topics> getTopics(int id);
	public Topics getTopic(int id,int id1); 
	public String add(int id , Topics topics);
	public String updateByTopic(int id,String d);
	public String updateByPath(int id,String d);
	public String delete(int id);
}
