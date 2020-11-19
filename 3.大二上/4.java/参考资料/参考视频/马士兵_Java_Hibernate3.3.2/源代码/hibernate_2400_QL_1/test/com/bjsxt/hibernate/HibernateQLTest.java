package com.bjsxt.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query; 

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
	@Test
	public void testHQL_01() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category");
		List<Category> categories = (List<Category>)q.list();
		for(Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_02() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category c where c.name > 'c5'");
		List<Category> categories = (List<Category>)q.list();
		for(Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_03() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category c order by c.name desc");
		List<Category> categories = (List<Category>)q.list();
		for(Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_04() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select distinct c from Category c order by c.name desc");
		List<Category> categories = (List<Category>)q.list();
		for(Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_05() {
		Session session = sf.openSession();
		session.beginTransaction();
		/*Query q = session.createQuery("from Category c where c.id > :min and c.id < :max");
		//q.setParameter("min", 2);
		//q.setParameter("max", 8);
		q.setInteger("min", 2);
		q.setInteger("max", 8);*/
		
		Query q = session.createQuery("from Category c where c.id > :min and c.id < :max")
			.setInteger("min", 2)
			.setInteger("max", 8);
		List<Category> categories = (List<Category>)q.list();
		for(Category c : categories) {
			System.out.println(c.getId() + "-" + c.getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_06() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category c where c.id > ? and c.id < ?");
		q.setParameter(0, 2)
			.setParameter(1, 8);
//		q.setParameter(1, 8);
		List<Category> categories = (List<Category>)q.list();
		for(Category c : categories) {
			System.out.println(c.getId() + "-" + c.getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	//分页
	@Test
	public void testHQL_07() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category c order by c.name desc");
		q.setMaxResults(4);
		q.setFirstResult(2);
		List<Category> categories = (List<Category>)q.list();
		for(Category c : categories) {
			System.out.println(c.getId() + "-" + c.getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_08() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select c.id,  c.name from Category c order by c.name desc");
		List<Object[]> categories = (List<Object[]>)q.list();
		for(Object[] o : categories) {
			System.out.println(o[0] + "-" + o[1]);
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	//设定fetch type 为lazy后将不会有第二条sql语句
	@Test
	public void testHQL_09() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.category.id = 1");
		List<Topic> topics = (List<Topic>)q.list();
		for(Topic t : topics) {
			System.out.println(t.getTitle());
			//System.out.println(t.getCategory().getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	//设定fetch type 为lazy后将不会有第二条sql语句
	@Test
	public void testHQL_10() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.category.id = 1");
		List<Topic> topics = (List<Topic>)q.list();
		for(Topic t : topics) {
			System.out.println(t.getTitle());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_11() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Msg m where m.topic.category.id = 1");
		
		for(Object o : q.list()) {
			Msg m = (Msg)o;
			System.out.println(m.getCont());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	//了解即可
	//VO Value Object
	//DTO data transfer object
	@Test
	public void testHQL_12() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select new com.bjsxt.hibernate.MsgInfo(m.id, m.cont, m.topic.title, m.topic.category.name) from Msg");
		
		for(Object o : q.list()) {
			MsgInfo m = (MsgInfo)o;
			System.out.println(m.getCont());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	//动手测试left right join
	//为什么不能直接写Category名，而必须写t.category
	//因为有可能存在多个成员变量（同一个类），需要指明用哪一个成员变量的连接条件来做连接
	@Test
	public void testHQL_13() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select t.title, c.name from Topic t join t.category c "); //join Category c
		for(Object o : q.list()) {
			Object[] m = (Object[])o;
			System.out.println(m[0] + "-" + m[1]);
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	//学习使用uniqueResult
	@Test
	public void testHQL_14() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Msg m where m = :MsgToSearch "); //不重要
		Msg m = new Msg();
		m.setId(1);
		q.setParameter("MsgToSearch", m);
		
		Msg mResult = (Msg)q.uniqueResult();
		System.out.println(mResult.getCont());
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_15() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select count(*) from Msg m");
		
		long count = (Long)q.uniqueResult();
		System.out.println(count);
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_16() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select max(m.id), min(m.id), avg(m.id), sum(m.id) from Msg m");
		
		Object[] o = (Object[])q.uniqueResult();
		System.out.println(o[0] + "-" + o[1] + "-" + o[2] + "-" + o[3]);
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_17() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Msg m where m.id between 3 and 5");
		
		for(Object o : q.list()) {
			Msg m = (Msg)o;
			System.out.println(m.getId() + "-" + m.getCont());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_18() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Msg m where m.id in (3,4, 5)");
		
		for(Object o : q.list()) {
			Msg m = (Msg)o;
			System.out.println(m.getId() + "-" + m.getCont());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	//is null 与 is not null
	@Test
	public void testHQL_19() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Msg m where m.cont is not null");
		
		for(Object o : q.list()) {
			Msg m = (Msg)o;
			System.out.println(m.getId() + "-" + m.getCont());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
