package com.psl.main;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Contact c1 = new Contact("firstName1","lastName1",Date.valueOf("2001-01-01"));
		c1.setMobileNumbers(new HashSet<String>(Arrays.asList("123","456","789","012")));
		c1.getAddresses().add(new Address("city1","country1"));
		c1.getAddresses().add(new Address("city2","country2"));
		Contact c2 = new Contact("firstName2","lastName2",Date.valueOf("2002-02-02"));
		c2.setMobileNumbers(new HashSet<String>(Arrays.asList("012","987","654","321")));
		c2.getAddresses().add(new Address("city3","country3"));
		c2.getAddresses().add(new Address("city4","country4"));
		System.out.println(c2.getAddresses());
		//c1.setContactId(100);
		//c2.setContactId(200);
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory;
		sessionFactory = configuration.buildSessionFactory();
		Session session;
		session= sessionFactory.openSession();
		Transaction tx;
		tx= session.beginTransaction();
		session.save(c1);
		session.save(c2);
		
		tx.commit();
		session.close();
		
		sessionFactory.close();
	}

}
