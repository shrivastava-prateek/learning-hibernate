package com.psl.main;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
		System.out.println("------------------------------------------------------------Basic Criteria");
		Criteria criteria=session.createCriteria(User.class);
		List<User> usr_lst= criteria.list();
		for(User user : usr_lst){
			System.out.println(user.getFullName());
		}
		
		System.out.println("------------------------------------------------------------pagination");
		criteria=session.createCriteria(User.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(2);
		usr_lst= criteria.list();
		for(User user : usr_lst){
			System.out.println(user.getFullName());
		}
		System.out.println("------------------------------------------------------------Restrictions");
		criteria=session.createCriteria(Account.class);
		criteria.add(Restrictions.gt("balance", 2000.0));
		criteria.add(Restrictions.lt("balance", 5000.0));
		List<Account>acs_lst= criteria.list();
		for(Account user : acs_lst){
			System.out.println(user.getBalance());
		}
        
		System.out.println("-------------------------------------------------------------Associations");
		criteria = session.createCriteria(User.class);
		//criteria.createCriteria("accounts")
		criteria.createAlias("accounts", "a")
	            .add(Restrictions.gt("a.balance", 5000.0));
		usr_lst= criteria.list();
		for(User user : usr_lst){
			System.out.println(user.getFullName());
		}
		
		
		System.out.println("--------------------------------------------------------------Projections");
		criteria= session.createCriteria(User.class);
		ProjectionList p1=Projections.projectionList();
		p1.add(Projections.property("fullName"));
		p1.add(Projections.property("a.balance"));
		criteria.setProjection(p1).createAlias("accounts", "a");
		List<Object[]> obj_arr= criteria.list();
		for (Object[] objects : obj_arr) {
			System.out.println(objects[0]+"----"+objects[1]);
		}
		
		System.out.println("--------------------------------------------------------------agg/grp");
		criteria= session.createCriteria(User.class);
		p1=Projections.projectionList();
		p1.add(Projections.property("fullName"));
		p1.add(Projections.sum("a.balance"));
		p1.add(Projections.groupProperty("fullName"));
		criteria.setProjection(p1).createAlias("accounts", "a");
		obj_arr = criteria.list();
		for (Object[] objects : obj_arr) {
			System.out.println(objects[0]+"----"+objects[1]);
		}
		
		session.close();
		sessionFactory.close();
	}

}
