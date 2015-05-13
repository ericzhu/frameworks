package com.ez.banking.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ez.hibernate.HibernateUtil;

public abstract class BaseApp {
	protected Session session;
	
	public void runApp() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory(true);
		this.session = sessionFactory.openSession();
		this.session.beginTransaction();

		execute();

		this.session.getTransaction().commit();
		this.session.close();
		sessionFactory.close();
	}

	public abstract void execute();
}
