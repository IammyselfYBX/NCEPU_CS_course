package com.bjsxt.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class TeacherTest {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("t1");
		t.setTitle("middle");
		t.setBirthDate(new Date());
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}
}
