package com.amrit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	private static SessionFactory factory; 
	
	public static void main(String[] args){
	
		try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
		
		Student stu = new Student();
		stu.setRollNo(1);
		stu.setName("Amrit");
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(stu);
		
		session.getTransaction().commit();
		session.close();
		
	}
	

}
