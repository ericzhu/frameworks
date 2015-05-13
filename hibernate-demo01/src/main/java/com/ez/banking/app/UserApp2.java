package com.ez.banking.app;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ez.banking.entity.User;
import com.ez.hibernate.HibernateUtil;

public class UserApp2 {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory(true);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User u = new User();
		u.setFirstName("Eric");
		u.setLastName("Zhu");
		u.setBirthDate(getBirtDate());
		u.setLastUpdatedDate(new Date());
		u.setLastUpdatedBy("Eric");
		u.setCreatedDate(new Date());
		u.setCreatedBy("Eric");
		u.setEmailAddress("eric@eric.com");
		session.save(u);
		
		session.getTransaction().commit();
		
		session.refresh(u);
		
		System.out.println("--- age: " + u.getAge());
		
		session.close();
		sessionFactory.close();
	}
	
	public static Date getBirtDate() {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1980);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 27);
		
		return calendar.getTime();
	}
}
