package com.example.demo.elearning.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="topics")
public class Topics {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	@Column(name="topic")
	private String topic;
	@Column(name="path")
	private String path; 
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="topic_id") 
	private List<Comment> comment;
	
	public Topics()
	{
		
	}

	public Topics(String topic, String path) {
		this.topic = topic;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Topics [id=" + id + ", topic=" + topic + ", path=" + path + "]";
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	public void addComment(Topics topic,Comment comment)
	{
		topic.comment.add(comment);
	}	

	public Comment getCommentById(Topics topic,int id2)
	{
		List<Comment> comment=topic.getComment();
		Comment c1=null;
		for(Comment c:comment)
		{
			if(c.getId()==id2)
			{
				c1=c;
				break;
			}
		}
		return c1;
	}
	
	
}
