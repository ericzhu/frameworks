package com.ez.banking.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ez.banking.entity.User;
import com.ez.hibernate.HibernateUtil;

public class UserApp1 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory(true);
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		User u = new User();
		u.setFirstName("Eric");
		u.setLastName("Zhu");
		u.setBirthDate(new Date());
		u.setLastUpdatedDate(new Date());
		u.setLastUpdatedBy("Eric");
		u.setCreatedDate(new Date());
		u.setCreatedBy("Eric");
		u.setEmailAddress("eric@eric.com");

		session.save(u);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
