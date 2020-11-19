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
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
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
	public void testOperation1() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Account a = (Account)session.load(Account.class, 1);
		int balance = a.getBalance();
		//do some caculations
		balance = balance - 10;
		a.setBalance(balance);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testPessimisticLock() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Account a = (Account)session.load(Account.class, 1, LockMode.UPGRADE);
		int balance = a.getBalance();
		//do some caculation
		balance = balance - 10;
		a.setBalance(balance);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
