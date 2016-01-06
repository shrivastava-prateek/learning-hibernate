package com.psl.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Contact;

public class Main {


	public static void main(String[] args) {

		Contact c1 = new Contact("firstName1","lastName1",Date.valueOf("2001-01-01"),"email1");
		Contact c2 = new Contact("firstName2","lastName2",Date.valueOf("2002-02-02"),"email2");
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
		session.clear();

		session.close();
		
		sessionFactory.close();
	}

}
