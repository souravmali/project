package com.cjc.CRUD_MVC.DaoImplimentation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.cjc.CRUD_MVC.DaoInterface.Dao_Inter;
import com.cjc.CRUD_MVC.Utility.HibernateUtil;
import com.cjc.CRUD_MVC.model.Student;

public class Dao_Impl implements Dao_Inter
{

	@Override
	public void saveStudent(Student s) 
	{
		Session session=HibernateUtil.getsessionfactory().openSession();
		session.save(s);
		session.beginTransaction().commit();
		
	}

	@Override
	public List<Student> logincheck(String username, String password) 
	{
		Session session=HibernateUtil.getsessionfactory().openSession();
		List<Student> sl= new ArrayList<>();
		Student s=new Student();
		if (username.equals("admin")&&password.equals("admin")) 
		{	
			sl =session.createQuery("From Student").getResultList();	
		}
		
		else 
		{
			//sl =session.createQuery("From Student").getResultList();
			Query q=session.createQuery("From Student where rollno=? and password=?");
			q.setParameter(0, username);
			q.setParameter(1, password);
			sl = q.getResultList(); 
		}

		return sl;
	}

	@Override
	public List<Student> getAll() 
	{
		Session session=HibernateUtil.getsessionfactory().openSession();
		List<Student> sl=new ArrayList<>();
		
		sl=session.createQuery("From Student").getResultList();
		return sl;
	}

	@Override
	public void deleteRecord(int rollno) {
		
		Session session=HibernateUtil.getsessionfactory().openSession();
		Student s=session.get(Student.class, rollno);
		
		session.delete(s);
		session.beginTransaction().commit();
		
	}

	@Override
	public Student editStudent(int rollno) 
	{
		Session session=HibernateUtil.getsessionfactory().openSession();
		Student s=session.get(Student.class, rollno);
		
	
		return s;
	}

	@Override
	public void updateStudent(Student s) {
		
		Session session=HibernateUtil.getsessionfactory().openSession();
		/*Student s1 = session.get(Student.class, s.getRollno());
		s1.setName(s.getName());
		s1.setAddress(s.getAddress());
		s1.setEmail(s.getEmail());
		s1.setUsername(s.getUsername());
		s1.setPassword(s.getPassword());
		System.out.println("Updated Successfully !!!");
*/		session.update(s);
		session.beginTransaction().commit();

	}

}
