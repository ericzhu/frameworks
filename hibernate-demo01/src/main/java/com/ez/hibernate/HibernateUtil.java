package com.ez.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ez.banking.entity.User;

public class HibernateUtil {

	private static SessionFactory buildSessionFactoryFromPropertiesConfig() {
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(User.class);
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to create SessionFactory");
		}
	}

	private static SessionFactory buildSessionFactoryFromXmlConfig() {
		try {
			Configuration configuration = new Configuration().configure();
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
					.build());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to create SessionFactory");
		}
	}

	public static SessionFactory getSessionFactory(boolean isXmlConfig) {
		return isXmlConfig ? buildSessionFactoryFromXmlConfig() : buildSessionFactoryFromPropertiesConfig();
	}
}
