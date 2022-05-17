package org.tareq23.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tareq23.hibernate.entity.Users;

public class App {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Users.class)
										.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create object of entity class type
			Users user = new Users("firstName", "lastName", "username", "password");
			
			// Start transaction
			session.beginTransaction();
			
			// perform operation
			
			session.save(user);
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("New Row Added");
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
