package com.psl.main;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mysql.jdbc.BalanceStrategy;
import com.psl.bean.Account;
import com.psl.bean.User;

public class Main {

	public static void main(String[] args) {

		User u1= new User("Prateek");
		User u2= new User("Rajmaah");
		User u3= new User("Paa");
		User u4= new User("Mohit");
		User u5= new User("Mayank");
		
		u1.addAccount(new Account(1234.56));
		u1.addAccount(new Account(124.56));
		u2.addAccount(new Account(234.56));
		u2.addAccount(new Account(2234.56));
		u2.addAccount(new Account(214.56));
		u3.addAccount(new Account(34.56));
		u4.addAccount(new Account(4321.56));

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
		session.save(u5);
		
		tx.commit();
		session.clear();
		
		System.out.println("---------------------------------------------basic HQL");
		Query query= session.createQuery("from User");
		List<User> usr_lst=query.list();
		for (User user : usr_lst) {
			System.out.println(user.getFullName());
		}
		
		System.out.println("---------------------------------------------native SQL");
		SQLQuery sqlQuery= session.createSQLQuery("select * from tbl_users");
		List<Object[]> usr_obj_arr=sqlQuery.list();
		for (Object[] objects : usr_obj_arr) {
			System.out.println(objects[0]+"----"+objects[1]);
		}
		
		System.out.println("---------------------------------------------Pagination");
		query= session.createQuery("from User");
		query.setFirstResult(0);
		query.setMaxResults(3);
		usr_lst=query.list();
		for (User user : usr_lst) {
			System.out.println(user.getFullName());
		}
		
		System.out.println("---------------------------------------------named parameter");
		query= session.createQuery("from Account where balance > :amt");
		query.setDouble("amt",2000.00);
		List<Account> acs_lst=query.list();
		for (Account account : acs_lst) {
			System.out.println(account.getBalance());
		}
		
		System.out.println("----------------------------------------------Named queries/Externalized queries");
		query=session.getNamedQuery("findBalanceLessThan");
		query.setDouble("amt", 2000.00);
		acs_lst=query.list();
		for (Account account : acs_lst) {
			System.out.println(account.getBalance());
		}
		
		System.out.println("-----------------------------------------------------------------------------");
		query= session.createQuery("from User u where u.accounts is empty");
		usr_lst=query.list();
		for (User user : usr_lst) {
			System.out.println(user.getFullName());
		}
		
		System.out.println("-----------------------------------------------------Sub Query");
		query=session.createQuery("from User u where u.userId not in (select user.userId from Account)");
		usr_lst=query.list();
		for (User user : usr_lst) {
			System.out.println(user.getFullName());
		}
		
		System.out.println("-----------------------------------------------------Projection");
		query = session.createQuery("select u.fullName,a.balance from User u,Account a where u.userId = a.user.userId");
		usr_obj_arr=query.list();
		for (Object[] objects : usr_obj_arr) {
			System.out.println(objects[0]+"----"+objects[1]);
		}
		
		System.out.println("------------------------------------------------------Aggregation/Grouping");
		query = session.createQuery("select u.fullName, sum(a.balance) from User u left outer join" +
				                    " u.accounts a group by u.fullName");
		usr_obj_arr=query.list();
		for (Object[] objects : usr_obj_arr) {
			System.out.println(objects[0]+"----"+objects[1]);
		}
		
		session.close();
		sessionFactory.close();
	}

}
