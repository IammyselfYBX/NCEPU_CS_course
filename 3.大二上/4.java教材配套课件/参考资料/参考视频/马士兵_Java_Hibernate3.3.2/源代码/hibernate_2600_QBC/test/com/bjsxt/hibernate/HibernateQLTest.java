package com.bjsxt.hibernate;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.FetchMode;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
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
			session.save(c);
		}
		
		for(int i=0; i<10; i++) {
			Category c = new Category();
			c.setId(1);
			Topic t = new Topic();
			t.setCategory(c);
			t.setTitle("t" + i);
			t.setCreateDate(new Date());
			session.save(t);
			
		}
		
		for(int i=0; i<10; i++) {
			
			Topic t = new Topic();
			t.setId(1);
			Msg m = new Msg();
			m.setCont("m" + i);
			m.setTopic(t);
			session.save(m);
			
		}
		
		
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	//is empty and is not empty
	@Test
	public void testQBC() {
		Session session = sf.openSession();
		session.beginTransaction();
		//criterion 标准/准则/约束
		Criteria c = session.createCriteria(Topic.class) //from Topic
					 
					 .add(Restrictions.gt("id", 2)) //greater than = id > 2
					 .add(Restrictions.lt("id", 8)) //little than = id < 8
					 .add(Restrictions.like("title", "t_"))
					 .createCriteria("category")
					 .add(Restrictions.between("id", 3, 5)) //category.id >= 3 and category.id <=5
					 ;
		//DetachedCriterea
		for(Object o : c.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getId() + "-" + t.getTitle());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
