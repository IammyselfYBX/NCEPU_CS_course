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
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void testSave() {
		Org o = new Org();
		o.setName("总公司");
		Org o1 = new Org();
		o1.setName("分公司1");
		Org o2 = new Org();
		o2.setName("分公司2");
		Org o11 = new Org();
		o11.setName("分公司1下部门1");
		Org o12 = new Org();
		o12.setName("分公司1下部门2");
		
		o.getChildren().add(o1);
		o.getChildren().add(o2);
		o1.getChildren().add(o11);
		o1.getChildren().add(o12);
		o11.setParent(o1);
		o12.setParent(o1);
		o1.setParent(o);
		o2.setParent(o);
				
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(o);
	
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void testLoad() {
		testSave();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Org o = (Org)session.load(Org.class, 1);
		print(o, 0);
		session.getTransaction().commit();
		session.close();
		
	}
	
	private void print(Org o, int level) {
		String preStr = "";
		for(int i=0; i<level; i++) {
			preStr += "----";
		}
		System.out.println(preStr + o.getName());
		for(Org child : o.getChildren()) {
			print(child, level+1);
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
