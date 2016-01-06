package com.psl.main;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;
import com.psl.bean.Degree;
import com.psl.bean.Profile;
import com.psl.bean.User;

public class Main {

	public static void main(String[] args) {
        User u1= new User("Bruce Wayne");
        User u2= new User("Peter Parker");
        User u3= new User("Clark Kent");
        User u4= new User("Tony Stark");
        
		Contact c1 = new Contact("firstName1","lastName1",Date.valueOf("2001-01-01"));
		c1.setMobileNumbers(new HashSet<String>(Arrays.asList("123","456","789","012")));
		c1.getAddresses().add(new Address("city0","country0"));
		c1.getAddresses().add(new Address("city1","country1"));
		
		Contact c2 = new Contact("firstName2","lastName2",Date.valueOf("2002-02-02"));
		c2.setMobileNumbers(new HashSet<String>(Arrays.asList("012","987","654","321")));
		c2.getAddresses().add(new Address("city1","country1"));
		c2.getAddresses().add(new Address("city2","country2"));
		
		Contact c3 = new Contact("firstName3","lastName3",Date.valueOf("2001-01-01"));
		c3.setMobileNumbers(new HashSet<String>(Arrays.asList("123","456","789","012")));
		c3.getAddresses().add(new Address("city2","country2"));
		c3.getAddresses().add(new Address("city3","country3"));
		
		Contact c4 = new Contact("firstName4","lastName4",Date.valueOf("2001-01-01"));
		c4.setMobileNumbers(new HashSet<String>(Arrays.asList("123","456","789","012")));
		c4.getAddresses().add(new Address("city3","country3"));
		c4.getAddresses().add(new Address("city4","country4"));
		
		Contact c5 = new Contact("firstName5","lastName5",Date.valueOf("2001-01-01"));
		c5.setMobileNumbers(new HashSet<String>(Arrays.asList("123","456","789","012")));
		c5.getAddresses().add(new Address("city1","country1"));
		c5.getAddresses().add(new Address("city2","country2"));
		
		Contact c6 = new Contact("firstName6","lastName6",Date.valueOf("2001-01-01"));
		c6.setMobileNumbers(new HashSet<String>(Arrays.asList("123","456","789","012")));
		c6.getAddresses().add(new Address("city3","country3"));
		c6.getAddresses().add(new Address("city4","country4"));
		
		Contact c7 = new Contact("firstName7","lastName7",Date.valueOf("2001-01-01"));
		c7.setMobileNumbers(new HashSet<String>(Arrays.asList("123","456","789","012")));
		c7.getAddresses().add(new Address("city5","country5"));
		c7.getAddresses().add(new Address("city6","country6"));
		
		Contact c8 = new Contact("firstName8","lastName8",Date.valueOf("2001-01-01"));
		c8.setMobileNumbers(new HashSet<String>(Arrays.asList("123","456","789","012")));
		c8.getAddresses().add(new Address("city7","country7"));
		c8.getAddresses().add(new Address("city8","country8"));
		
		Degree d1= new Degree("MBA");
		Degree d2= new Degree("CA");
		Degree d3= new Degree("CS");
		Degree d4= new Degree("BE");
		
		Profile p1=new Profile("school1","college1");
		Profile p2=new Profile("school2","college2");
		Profile p3=new Profile("school3","college3");
		Profile p4=new Profile("school4","college4");
		Profile p5=new Profile("school5","college5");
		Profile p6=new Profile("school6","college6");
		Profile p7=new Profile("school7","college7");
		Profile p8=new Profile("school8","college8");
		
		p1.addDegree(d1);
		p1.addDegree(d2);
		p1.addDegree(d4);
		p3.addDegree(d2);
		p3.addDegree(d3);
		p4.addDegree(d1);
		p4.addDegree(d4);
		p4.addDegree(d3);
		p5.addDegree(d1);
		p5.addDegree(d2);
		p6.addDegree(d3);
		p6.addDegree(d1);
		p6.addDegree(d2);
		p7.addDegree(d1);
		p7.addDegree(d2);
		p8.addDegree(d3);
		
		c1.addProfile(p1);
		c2.addProfile(p2);
		c3.addProfile(p3);
		c4.addProfile(p4);
		c5.addProfile(p5);
		c6.addProfile(p6);
		c7.addProfile(p7);
		c8.addProfile(p8);
		
		
		u1.addContact(c1);
		u1.addContact(c2);
		u2.addContact(c3);
		u2.addContact(c4);
		u2.addContact(c5);
		u3.addContact(c6);
		u3.addContact(c7);
		u3.addContact(c8);

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory;
		sessionFactory = configuration.buildSessionFactory();
		Session session;
		session= sessionFactory.openSession();
		Transaction tx;
		tx= session.beginTransaction();
		
		session.save(u1);
		
		session.save(u2);
		
		session.save(u3);
		
		session.save(u4);
		
		
		tx.commit();
		session.clear();
		
		/*Query query=session.createQuery("from User");
		List<User> users= query.list();
		for (User user : users) {
			System.out.println(user.getUserName());
		}*/
		
		Profile p=(Profile)session.get(Profile.class, new Integer(4));
		
		session.close();
		
		sessionFactory.close();
	}

}
