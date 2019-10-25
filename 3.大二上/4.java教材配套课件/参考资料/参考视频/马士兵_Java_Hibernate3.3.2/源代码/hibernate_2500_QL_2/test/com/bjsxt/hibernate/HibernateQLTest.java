package com.bjsxt.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
	
	//is empty and is not empty
	@Test
	public void testHQL_20() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.msgs is empty");
		
		for(Object o : q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getId() + "-" + t.getTitle());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_21() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.title like '%5'");
		
		for(Object o : q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getId() + "-" + t.getTitle());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_22() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.title like '_5'");
		
		for(Object o : q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getId() + "-" + t.getTitle());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	//不重要
	@Test
	public void testHQL_23() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select lower(t.title)," +
											 "upper(t.title)," +
											 "trim(t.title)," +
											 "concat(t.title, '***')," +
											 "length(t.title)" +
											 " from Topic t ");
		
		for(Object o : q.list()) {
			Object[] arr = (Object[])o;
			System.out.println(arr[0] + "-" + arr[1] + "-" + arr[2] + "-" + arr[3] + "-" + arr[4] + "-");
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_24() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select abs(t.id)," +
											 "sqrt(t.id)," +
											 "mod(t.id, 2)" +
											 " from Topic t ");
		
		for(Object o : q.list()) {
			Object[] arr = (Object[])o;
			System.out.println(arr[0] + "-" + arr[1] + "-" + arr[2] );
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_25() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select current_date, current_time, current_timestamp, t.id from Topic t");
		
		for(Object o : q.list()) {
			Object[] arr = (Object[])o;
			System.out.println(arr[0] + " | " + arr[1] + " | " + arr[2] + " | " + arr[3]);
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_26() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.createDate < :date");
		q.setParameter("date", new Date());
		for(Object o : q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getTitle());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_27() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select t.title, count(*) from Topic t group by t.title") ;
		for(Object o : q.list()) {
			Object[] arr = (Object[])o;
			System.out.println(arr[0] + "|" + arr[1]);
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_28() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("select t.title, count(*) from Topic t group by t.title having count(*) >= 1") ;
		for(Object o : q.list()) {
			Object[] arr = (Object[])o;
			System.out.println(arr[0] + "|" + arr[1]);
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_29() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.id < (select avg(t.id) from Topic t)") ;
		for(Object o : q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getTitle());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_30() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.id < ALL (select t.id from Topic t where mod(t.id, 2)= 0) ") ;
		for(Object o : q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getTitle());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	//用in 可以实现exists的功能
	//但是exists执行效率高
	@Test
	public void testHQL_31() {
		Session session = sf.openSession();
		session.beginTransaction();// t.id not in (1)
		Query q = session.createQuery("from Topic t where not exists (select m.id from Msg m where m.topic.id=t.id)") ;
//		Query q = session.createQuery("from Topic t where exists (select m.id from Msg m where m.topic.id=t.id)") ;
		for(Object o : q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getTitle());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	//update and delete
	//规范并没有说明是不是要更新persistent object，所以如果要使用，建议在单独的trasaction中执行
	
	@Test
	public void testHQL_32() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("update Topic t set t.title = upper(t.title)") ;
		
		q.executeUpdate();
		q = session.createQuery("from Topic");
		for(Object o : q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getTitle());
		}
		session.createQuery("update Topic t set t.title = lower(t.title)")
			.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
	}
	
	//不重要
	@Test
	public void testHQL_33() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.getNamedQuery("topic.selectCertainTopic");
		q.setParameter("id", 5);
		Topic t = (Topic)q.uniqueResult();
		System.out.println(t.getTitle());
		session.getTransaction().commit();
		session.close();
		
	}
	
	//Native（了解）
	@Test
	public void testHQL_34() {
		Session session = sf.openSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery("select * from category limit 2,4").addEntity(Category.class);
		List<Category> categories = (List<Category>)q.list();
		for(Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testHQL_35() {
		//尚未实现JPA命名的NativeSQL
		
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
