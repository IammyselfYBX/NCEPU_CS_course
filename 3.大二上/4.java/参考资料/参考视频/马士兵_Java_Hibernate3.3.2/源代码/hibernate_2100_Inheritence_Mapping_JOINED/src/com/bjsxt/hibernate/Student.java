package com.bjsxt.hibernate;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
	
	private int score;

	public int getScore() {
		return score;
	} //Person p = Person(load(1));

	public void setScore(int score) {
		this.score = score;
	}
	
}
