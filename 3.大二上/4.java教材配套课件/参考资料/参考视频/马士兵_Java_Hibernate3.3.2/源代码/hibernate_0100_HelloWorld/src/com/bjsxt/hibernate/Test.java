package com.bjsxt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test {
	public static void main(String[] args) {
		Student s = new Student();
		s.setId(1);
		s.setName("zhangsan");
		s.setAge(8);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		
	}
}
