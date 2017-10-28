package com.hibernate.map;

import java.util.List;

import org.hibernate.Session;

import com.hibernate.map.model.Address;
import com.hibernate.map.model.Student;

public class HibernateStandAlone {
	
	    @SuppressWarnings("unchecked")
	    public static void main(String[] args) {
	 
	        Student student = new Student("Sam","Disilva","Maths");
	        Address address = new Address("10 Silver street","NYC","USA");
	       
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	 
//	        student.setAddress(address);   
//	        address.setStudent(student);
//	        session.save(student);
     
	        session.persist(address);
	        student.setAddress(address);
	        session.persist(student);
	         
	        List<Student> students = (List<Student>)session.createQuery("from Student ").list();
	        for(Student s: students){
	            System.out.println("Details : "+s);
	        }
	         
	        session.getTransaction().commit();
	        session.close();  
	    }

}
