package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating 3 students objects...");
			Student tempStudent1 = new Student("Karl", "Marckes", "MM@gmail.com");
			tempStudent1.setId(19);
			System.out.println("Karl id : "+tempStudent1.getId());
			/*Student tempStudent2 = new Student("Mary", "Tehnighto", "Mary@gmail.com");
			Student tempStudent3 = new Student("Juda", "s", "Juda@gmail.com");*/
			session.beginTransaction();
			System.out.println("Saving the students");
			session.save(tempStudent1);
			/*session.save(tempStudent2);
			session.save(tempStudent3);*/
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			factory.close();
		}
	}

}
