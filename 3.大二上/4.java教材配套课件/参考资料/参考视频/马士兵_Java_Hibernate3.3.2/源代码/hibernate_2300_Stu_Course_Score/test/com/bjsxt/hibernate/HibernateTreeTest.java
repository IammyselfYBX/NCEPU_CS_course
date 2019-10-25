package com.bjsxt.hibernate;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateTreeTest {
	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void beforeClass() {
		//new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void testSave() {
		Student s = new Student();
		s.setName("zhangsan");
		Course c = new Course();
		c.setName("java");
		Score score = new Score();
		score.setCourse(c);
		score.setStudent(s);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(s);
		session.save(c);
		session.save(score);
	
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void testLoad() {
		testSave();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Student s = (Student)session.load(Student.class, 1);
		for(Course c : s.getCourses()) {
			System.out.println(c.getName());
		}
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	
	public static void main(String[] args) {
		beforeClass();
	}
}
