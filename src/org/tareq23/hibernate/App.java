package org.tareq23.hibernate;

import java.util.ArrayList;
import java.util.List;

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
			
//			Users user = new Users("Rahul", "Roy", "rahul_roy", "password");
			
			Users user = new Users();
			
			
			
			// Start transaction
			session.beginTransaction();
			
			// perform operation
			
//			session.save(user);
			
			user = session.get(Users.class, 12);
			user.setFirstName("Sumon");
			System.out.println(user);
			
			// commit the transaction
			session.getTransaction().commit();
//			System.out.println("New Row Added");
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
