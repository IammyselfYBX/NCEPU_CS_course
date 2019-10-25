package com.bjsxt.hibernate;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
