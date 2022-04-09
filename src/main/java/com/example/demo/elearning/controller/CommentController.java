package com.example.demo.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.elearning.entity.Comment;
import com.example.demo.elearning.serviceimpl.CommentServiceImp;

@RestController
public class CommentController {
	
	private CommentServiceImp commentServiceImp;
	
	@Autowired
	public CommentController(CommentServiceImp commentServiceImp) {
		this.commentServiceImp = commentServiceImp;
	}

	@GetMapping("/getcomments/{id}/{id1}")
	public List<Comment> getBYComments(@PathVariable int id,@PathVariable int id1) {
		return commentServiceImp.getComments(id, id1);
	}
	@GetMapping("/getcomment/{id}/{id1}/{id2}")
	public Comment getByComment(@PathVariable int id,@PathVariable int id1,@PathVariable int id2) {
		return commentServiceImp.getComment(id, id1, id2);
	}
	@PostMapping("/addcomment/{id}/{id1}")
	public String addTopic(@PathVariable int id,@PathVariable int id1,@RequestBody Comment comment) {
		commentServiceImp.add(id, id1, comment);
		return "Added";
	}
	
	@PutMapping("/deletecomment/{id2}")
	public String deleteComment(@PathVariable int id2) {
		commentServiceImp.delete(id2);
		return "Deleted";
	}

}
