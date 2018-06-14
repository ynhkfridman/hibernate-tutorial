package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object...");
			Student tempStudent=new Student("Daffy","Duck","Paul@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			session.getTransaction().commit();
			
			//MY NEW CODE

			//find the student's id primary key
			session=factory.getCurrentSession();
			session.beginTransaction();
			Student myStu = session.get(Student.class, tempStudent.getId());
			System.out.println(myStu);
			session.getTransaction().commit();
			System.out.println("Done");

		}finally {
			factory.close();
		}
		
	}

}
