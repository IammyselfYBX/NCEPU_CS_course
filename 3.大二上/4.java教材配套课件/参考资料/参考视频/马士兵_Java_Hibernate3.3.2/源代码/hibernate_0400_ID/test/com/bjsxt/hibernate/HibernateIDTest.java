package com.bjsxt.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateIDTest {
	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void beforeClass() {
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void testStudentSave() {
		StudentPK pk = new StudentPK();
		pk.setId(1);
		pk.setName("zhangsan");
		Student s = new Student();
		s.setPk(pk);
		s.setAge(8);
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
	}
	
	@Test
	public void testTeacherSave() {
	
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("t1");
		t.setTitle("middle");
		t.setBirthDate(new Date());
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
