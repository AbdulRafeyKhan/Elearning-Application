
package com.example.demo.elearning.entity;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="author")
	private String author;
	@Column(name="length")
	private String length;
	@Column(name="certificate")
	private String certificate;


	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="course_id") 
	private List<Topics> topics;
	
    @ManyToMany
    @JoinTable(name="student_course",
    joinColumns=@JoinColumn(name="course_id"),
    inverseJoinColumns=@JoinColumn(name="student_id"))
    
    private List<Student> student;
	 
	
	
	 public Course() {
	 
	 }
	 
	public Course(String title, String description, String author, String length,String certificate) {
		this.title = title;
		this.description = description;
		this.author = author;
		this.length = length;
		this.certificate = certificate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
	public List<Topics> getTopics() {
		return topics;
	}

	public void setTopics(List<Topics> topics) {
		this.topics = topics;
	}
	public void addtopic(Course course,Topics topic)
	{
		course.topics.add(topic);
	}
	public Topics getTopic(Course course,int id1)
	{
		List<Topics> topic=course.getTopics();
		Topics t1=null;
		for(Topics t:topic)
		{
			if(t.getId()==id1)
			{
				t1=t;
				break;
			}
		}
		return t1;
	}
	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
				+ ", length=" + length + ", certificate=" + certificate + "]";
	}
	

}
