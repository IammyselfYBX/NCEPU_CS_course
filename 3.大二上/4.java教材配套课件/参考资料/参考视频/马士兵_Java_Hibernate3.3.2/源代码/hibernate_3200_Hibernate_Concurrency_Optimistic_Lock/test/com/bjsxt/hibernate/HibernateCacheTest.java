package com.bjsxt.hibernate;

import java.math.BigDecimal;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateCacheTest {
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
		new SchemaExport(new AnnotationConfiguration().configure()).create(
				false, true);
	}

	@Test
	public void testSave() {
		Session session = sf.openSession();
		session.beginTransaction();

		Account a = new Account();
		a.setBalance(100);
		session.save(a);

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testOptimisticLock() {
		Session session = sf.openSession();

		Session session2 = sf.openSession();

		
		
		
		session.beginTransaction();
		Account a1 = (Account) session.load(Account.class, 1);
		

		session2.beginTransaction();
		Account a2 = (Account) session2.load(Account.class, 1);
		
		a1.setBalance(900);
		a2.setBalance(1100);

		session.getTransaction().commit();
		System.out.println(a1.getVersion());

		session2.getTransaction().commit();
		System.out.println(a2.getVersion());

		session.close();
		session2.close();
	}

	public static void main(String[] args) {
		beforeClass();
	}
}
