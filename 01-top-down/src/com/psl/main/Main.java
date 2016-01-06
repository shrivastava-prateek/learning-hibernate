package com.psl.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Contact;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Contact c1 = new Contact("firstName1","lastName1",Date.valueOf("2001-01-01"));
		Contact c2 = new Contact("firstName2","lastName2",Date.valueOf("2002-02-02"));
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
		//session.clear();
		 tx.commit();
		//session.close();
		//session=sessionFactory.openSession();
		session.clear();
		//retrieval of an object
		Contact rc=(Contact)session.get(Contact.class, new Integer(1));
		System.out.println(rc.getFirstName());
		System.out.println(rc==c1);
		c1.setFirstName("new firstName");
		tx= session.beginTransaction();
		  //session.merge(c1);
		//session.saveOrUpdate(c1);
		//session.save(c1);
		 tx.commit();
		session.close();
		sessionFactory.close();
	}

}
