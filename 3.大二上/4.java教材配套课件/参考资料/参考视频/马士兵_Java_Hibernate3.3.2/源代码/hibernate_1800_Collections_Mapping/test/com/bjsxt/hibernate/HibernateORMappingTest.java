package com.bjsxt.hibernate;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateORMappingTest {
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
	public void testLoadGroup() {
		
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		//User u = (User)s.load(User.class, 1);
		//u.setGroup(null);
		//s.delete(u);
		Group g = (Group)s.load(Group.class, 1);
		for(Map.Entry<Integer, User> entry : g.getUsers().entrySet()) {
			System.out.println(entry.getValue().getName());
		}
		//s.createQuery("delete from User u where u.id = 1").executeUpdate();
		s.getTransaction().commit();
		
	}
	
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	
	public static void main(String[] args) {
		beforeClass();
	}
}
