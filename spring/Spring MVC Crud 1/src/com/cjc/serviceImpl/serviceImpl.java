package com.cjc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.daoI.DaoInterface;
import com.cjc.model.Student;
import com.cjc.servicel.ServiceInterface;


@Service
public class serviceImpl implements ServiceInterface
{
    @Autowired
    DaoInterface dio;
	@Override
	public int saveData(Student s)
	{
		int i = dio.saveData(s);
		return i;
	}
	@Override
	public List<Student> getalldata(String username, String password) {
		
		return dio.getalldata(username, password);
	}
	@Override
	public void delete(int rollno)
	{
		
	dio.delete(rollno);
	}
	@Override
	public List<Student> getall()
	{
		
		return dio.getall();
	}
	@Override
	public void update(int rollno) 
	{
	  dio.update(rollno);	
	}
	@Override
	public Student edit(int rollno)
	{
	Student	s=dio.edit(rollno);
		return s;
	}
	
	

}
