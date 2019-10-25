package com.bjsxt.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	private int id;
	private String name;
	private Set<Course> courses = new HashSet<Course>();
	
	@ManyToMany
	@JoinTable(name="score",
		joinColumns=@JoinColumn(name="student_id", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="course_id", referencedColumnName="id")
		)
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
