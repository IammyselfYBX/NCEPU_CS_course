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

public class HibernateORMappingTest {
	private static SessionFactory sessionFactory;
	
	//@BeforeClass
	public static void beforeClass() {
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	//@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	
	
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
