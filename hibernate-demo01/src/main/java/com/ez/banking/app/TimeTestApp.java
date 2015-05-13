package com.ez.banking.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ez.banking.entity.TimeTest;
import com.ez.hibernate.HibernateUtil;

public class TimeTestApp {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory(true);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TimeTest timeTest = new TimeTest(new Date());
		session.save(timeTest);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}