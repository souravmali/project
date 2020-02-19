package com.model;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

public class Operation 
{

	 Scanner sc=new Scanner(System.in);
	 Employee em=new Employee();
	
	public  void savedeatils()
	{
		Session session=HibernateUtil.getsessionfactore().openSession();
		System.out.println("How many records you want enter?");
		int n=sc.nextInt();
		
			
		
		System.out.println("Enter Employee Id");
		em.setEid(sc.nextInt());
		
		System.out.println("Enter Employee Name");
		em.setName(sc.next());
		
		System.out.println("Enter Employee City");
		em.setCity(sc.next());
		
		System.out.println("Enter Employee Email Id");
		em.setEmail(sc.next());
		
		session.save(em);
		
		
		session.beginTransaction().commit();
	}
	
	public void retriveall()
	{
		Session session=HibernateUtil.getsessionfactore().openSession();
		List<Employee> el=session.createQuery("From Employee").getResultList();
		for (Employee e:el)
		{
			System.out.println(e.getEid());
			System.out.println(e.getName());
			System.out.println(e.getCity());
			System.out.println(e.getEmail());
		}
	}
	
	public void singlerecord()
	{
		Session session=HibernateUtil.getsessionfactore().openSession();
		System.out.println("Enter Employee Id Whose Data you Want");
		Employee e=session.load(Employee.class, sc.nextInt());
		
		System.out.println(e.getEid());
		System.out.println(e.getName());
		System.out.println(e.getCity());
		System.out.println(e.getEmail());
	}
	
	public void updatedetails()
	{
		Session session=HibernateUtil.getsessionfactore().openSession();
		System.out.println("Enter Employee Which You Want to Update");
		Employee e=session.get(Employee.class, sc.nextInt());
		System.out.println("Enter Employee New Name");
		e.setName(sc.next());
		System.out.println("Enter Employee New City");
		e.setCity(sc.next());
		System.out.println("Enter Employee New Email Id");
		e.setEmail(sc.next());
		
		session.update(e);
		session.beginTransaction().commit();
		System.out.println("Updated Successfully..!!");
		
	}
	
	public void deletedetails()
	{
		Session session=HibernateUtil.getsessionfactore().openSession();
		System.out.println("Enter Employee Id Which You Want To Delete ");
		
		Employee e=session.get(Employee.class, sc.nextInt());
		session.delete(e);
		session.beginTransaction().commit();
		System.out.println("Deleted Successfully..!!");
	}
}
