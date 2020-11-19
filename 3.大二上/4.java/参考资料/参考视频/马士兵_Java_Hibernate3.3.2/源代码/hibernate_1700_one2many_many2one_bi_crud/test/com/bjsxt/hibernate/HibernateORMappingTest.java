package com.bjsxt.hibernate;

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
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void testSaveUser() {
		User u = new User();
		u.setName("u1");
		Group g = new Group();
		g.setName("g1");
		u.setGroup(g);
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		//s.save(g);
		s.save(u);
		s.getTransaction().commit();
	}
	
	@Test
	public void testSaveGroup() {
		User u1 = new User();
		u1.setName("u1");
		User u2 = new User();
		u2.setName("u2");
		Group g = new Group();
		g.setName("g1");
		g.getUsers().add(u1);
		g.getUsers().add(u2);
		u1.setGroup(g);
		u2.setGroup(g);
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		//s.save(g);
		s.save(g);
		s.getTransaction().commit();
	}
	
	@Test
	public void testGetUser() {
		
		testSaveGroup();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.get(User.class, 1);
		
		s.getTransaction().commit();
		System.out.println(u.getGroup().getName());
	}
	
	@Test
	public void testLoadUser() {
		
		testSaveGroup();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.load(User.class, 1);
		System.out.println(u.getGroup().getName());
		s.getTransaction().commit();
		
	}
	
	@Test
	public void testDeleteUser() {
		
		testSaveGroup();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		//User u = (User)s.load(User.class, 1);
		//u.setGroup(null);
		//s.delete(u);
		s.createQuery("delete from User u where u.id = 1").executeUpdate();
		s.getTransaction().commit();
		
	}
	
	@Test
	public void testDeleteGroup() {
		
		testSaveGroup();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		//User u = (User)s.load(User.class, 1);
		//u.setGroup(null);
		//s.delete(u);
		Group g = (Group)s.load(Group.class, 1);
		s.delete(g);
		//s.createQuery("delete from User u where u.id = 1").executeUpdate();
		s.getTransaction().commit();
		
	}
	
	@Test
	public void testUpdateUser() {
		
		testSaveGroup();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.get(User.class, 1);
		
		s.getTransaction().commit();
		
		u.setName("user");
		u.getGroup().setName("group");
		
		Session s2 = sessionFactory.getCurrentSession();
		s2.beginTransaction();
		s2.update(u);
		
		s2.getTransaction().commit();
	}
	
	
	
	@Test
	public void testGetGroup() {
		
		testSaveGroup();
		
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		Group g = (Group)s.get(Group.class, 1);
		s.getTransaction().commit();
		for(User u : g.getUsers()) {
			System.out.println(u.getName());
		}
	}
	
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
