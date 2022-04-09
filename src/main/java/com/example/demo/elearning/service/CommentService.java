package com.example.demo.elearning.service;

import java.util.List;

import com.example.demo.elearning.entity.Comment;

public interface CommentService {
	
	public List<Comment> getComments(int id,int id1);
	public Comment getComment(int id,int id1,int id2);
	public String add(int id,int id1, Comment comment);
	public String delete(int id2);

}
