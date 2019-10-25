package com.bjsxt.hibernate;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateCoreAPITest {
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
	public void testTeacherSave() {
	
		Teacher t = new Teacher();
		
		t.setName("t1");
		t.setTitle("middle");
		t.setBirthDate(new Date());
		
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		session.save(t);
		
		Session session2 = sessionFactory.getCurrentSession();
		
		System.out.println(session == session2);
		
		session.getTransaction().commit();
		
		Session session3 = sessionFactory.getCurrentSession();
		
		System.out.println(session == session3);
		
		
	}
	
	@Test
	public void testSaveWith3State() {
	
		Teacher t = new Teacher();
		
		t.setName("t1");
		t.setTitle("middle");
		t.setBirthDate(new Date());
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		System.out.println(t.getId());
		session.getTransaction().commit();
		
		System.out.println(t.getId());
	}
	
	@Test
	public void testDelete() {
	
		Teacher t = new Teacher();
		t.setName("t1");
		t.setTitle("middle");
		t.setBirthDate(new Date());
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		System.out.println(t.getId());
		session.getTransaction().commit();
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.delete(t);
		session2.getTransaction().commit();
	}
	
	@Test
	public void testDelete2() {
	
		Teacher t = new Teacher();
		t.setId(2);
		
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.delete(t);
		session2.getTransaction().commit();
	}
	
	@Test
	public void testLoad() {
	
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.load(Teacher.class, 1);
		
		session.getTransaction().commit();
		System.out.println(t.getClass());
		//System.out.println(t.getName());
	}
	
	@Test
	public void testGet() {
	
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 1);
		
		session.getTransaction().commit();
		System.out.println(t.getClass());
		//System.out.println(t.getName());
	}
	
	@Test
	public void testUpdate1() {
	
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 1);
		
		session.getTransaction().commit();
		
		t.setName("zhanglaoshi");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.update(t);
		
		session2.getTransaction().commit();
	}
	
	@Test
	public void testUpdate2() {
		
		
		Teacher t = new Teacher();
		t.setName("zhanglaoshi");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.update(t);
		
		session2.getTransaction().commit();
	}
	
	@Test
	public void testUpdate3() {
		
		
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("zhanglaoshi");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.update(t);
		
		session2.getTransaction().commit();
	}
	
	@Test
	public void testUpdate4() {
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 1);
		t.setName("zhangsan2");
		session.getTransaction().commit();
	}
	
	@Test
	public void testUpdate5() {
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student s = (Student)session.get(Student.class, 1);
		s.setName("zhangsan5");
		session.getTransaction().commit();
		
		s.setName("z4");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.update(s);
		session2.getTransaction().commit();
	}
	
	@Test
	public void testUpdate6() {
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student s = (Student)session.get(Student.class, 1);
		s.setName("zhangsan6");
		session.getTransaction().commit();
		
		s.setName("z4");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.merge(s);
		session2.getTransaction().commit();
	}
	
	@Test
	public void testUpdate7() {
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("update Student s set s.name='z5' where s.id = 1");
		q.executeUpdate();
		session.getTransaction().commit();
		
	}
	
	@Test
	public void testSaveOrUpdate() {
		
		
		Teacher t = new Teacher();
		t.setName("t1");
		t.setTitle("middle");
		t.setBirthDate(new Date());
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(t);
		
		session.getTransaction().commit();
		
		t.setName("t2");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.saveOrUpdate(t);
		session2.getTransaction().commit();
		
	}
	
	@Test
	public void testClear() {
	
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.load(Teacher.class, 1);
		System.out.println(t.getName());
		
		session.clear();
		
		Teacher t2 = (Teacher)session.load(Teacher.class, 1);
		System.out.println(t2.getName());
		session.getTransaction().commit();
		
		
	}
	
	@Test
	public void testFlush() {
	
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.load(Teacher.class, 1);
		t.setName("tttt");
		
		
		session.clear();
		
		t.setName("ttttt");
		
	
		session.getTransaction().commit();
		
		
	}
	
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
