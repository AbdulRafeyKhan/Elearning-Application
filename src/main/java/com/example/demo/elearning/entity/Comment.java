package com.example.demo.elearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	@Column(name="doubt")	
	private String doubt;
	

	public Comment(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoubt() {
		return doubt;
	}
	public void setDoubt(String doubt) {
		this.doubt = doubt;
	}
	public Comment(String doubt) {
		this.doubt = doubt;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", doubt=" + doubt + "]";
	}
	
	

}
