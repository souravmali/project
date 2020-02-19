package com.cjc.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.daoI.DaoInterface;
import com.cjc.model.Student;
@Repository
public class DaoImpl implements DaoInterface
{
    @Autowired
    SessionFactory sf;
	@Override
	public int saveData(Student s)
	{
		Session session = sf.openSession();
		int i = (int)session.save(s);
		session.beginTransaction().commit();
		return i;
	}
	
	@Override
	public List<Student> getalldata(String username, String password)
	{
		if(username.equals("admin") && password.equals("admin"))
		{Session session=sf.openSession();
		 String hql="from Student " ;
		  Query q=session.createQuery(hql);
		  List<Student> l=q.getResultList();
			return l;
			
		}
		
		else
	{
	 Session session=sf.openSession();
	 String hql="from Student where Username='"+username+"'and Password='"+password+"'";
	 Query q=session.createQuery(hql);
	  List<Student> l=q.getResultList();
		return l;
	}
	}

	@Override
	public void delete(int rollno) 
	{
		Session session=sf.openSession();
		Student s=session.get(Student.class, rollno);
		session.delete(s);
		session.beginTransaction().commit();
		
	}

	@Override
	public List<Student> getall() 
	{
		Session session=sf.openSession();
		
		List<Student> l2=session.createQuery("from Student").getResultList();
		return l2;
	}

	@Override
	public void update(int rollno) 
	{
		Session session=sf.openSession();
		Student s=session.get(Student.class, rollno);
		session.update(s);
		session.beginTransaction().commit();
	}

	@Override
	public Student edit(int rollno)
{    
		Session session=sf.openSession();
        Student s=session.get(Student.class, rollno);
       session.beginTransaction().commit();
		
		return s;
	}


	
}
