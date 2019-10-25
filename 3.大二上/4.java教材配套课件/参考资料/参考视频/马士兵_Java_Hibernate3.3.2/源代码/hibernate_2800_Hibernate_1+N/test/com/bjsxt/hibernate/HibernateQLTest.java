package com.bjsxt.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateQLTest {
	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforeClass() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
	
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	@Test
	public void testSave() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		for(int i=0; i<10; i++) {
			Category c = new Category();
			c.setName("c" + i);
			Topic t = new Topic();
			t.setCategory(c);
			t.setTitle("t" + i);
			t.setCreateDate(new Date());
			session.save(c);
			session.save(t);
		}
			
		session.getTransaction().commit();
		session.close();
	}
	
	//N+1
	@Test
	public void testQuery1() {
		Session session = sf.openSession();
		session.beginTransaction();
		//List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();
		List<Topic> topics = (List<Topic>)session.createQuery("from Topic").list();
					 
		
		for(Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testQuery2() {
		Session session = sf.openSession();
		session.beginTransaction();
		//List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();
		List<Topic> topics = (List<Topic>)session.createQuery("from Topic").list();
					 
		
		for(Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
			System.out.println(t.getCategory().getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	//@BatchSize
	@Test
	public void testQuery3() {
		Session session = sf.openSession();
		session.beginTransaction();
		//List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();
		List<Topic> topics = (List<Topic>)session.createQuery("from Topic").list();
		
		for(Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
			System.out.println(t.getCategory().getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	//join fetch
	@Test
	public void testQuery4() {
		Session session = sf.openSession();
		session.beginTransaction();
		//List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();
		List<Topic> topics = (List<Topic>)session.createQuery("from Topic t left join fetch t.category c").list();
		
		for(Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
			System.out.println(t.getCategory().getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	public static void main(String[] args) {
		beforeClass();
	}
}
