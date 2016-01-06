package com.psl.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;
import com.psl.bean.Employee;
import com.psl.bean.Friend;
import com.psl.bean.Relative;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Contact c1 = new Friend("firstName1","lastName1",Date.valueOf("2001-01-01"),new Address("city1","country1"),
				                "Nicky1");
		Contact c2 = new Employee("firstName2","lastName2",Date.valueOf("2002-02-02"),new Address("city2","country2"),
				                  "EMP-002","Dept2","Desig2");
		Contact c3 = new Relative("firstName3","lastName3",Date.valueOf("2003-03-03"),new Address("city3","country3"),
                                  "relation3","petName3");
		//c1.setContactId(1);
		//c2.setContactId(2);
		//c3.setContactId(3);
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory;
		sessionFactory = configuration.buildSessionFactory();
		Session session;
		session= sessionFactory.openSession();
		Transaction tx;
		tx= session.beginTransaction();
		session.save(c1);
		session.save(c2);
		session.save(c3);
		
		tx.commit();
		session.clear();
		Contact _c=(Contact)session.get(Employee.class, new Integer(2));
		System.out.println(_c.getFirstName());
		session.close();
		
		sessionFactory.close();
	}

}
