package com.cjc.CRUD_MVC.ServiceImplimentation;

import java.util.List;

import com.cjc.CRUD_MVC.DaoImplimentation.Dao_Impl;
import com.cjc.CRUD_MVC.DaoInterface.Dao_Inter;
import com.cjc.CRUD_MVC.ServiceInterface.Service_Inter;
import com.cjc.CRUD_MVC.model.Student;

public class Service_Impl implements Service_Inter {

	Dao_Inter dio=new Dao_Impl();
	@Override
	public void saveStudent(Student s) {
	
		dio.saveStudent(s);
	}

	@Override
	public List<Student> logincheck(String username, String password) {
	
		List<Student> sl=dio.logincheck(username, password);
		return sl;
	}

	@Override
	public List<Student> getAll() {
	
		List<Student> sl=dio.getAll();
		return sl;
	}

	@Override
	public void deleteRecord(int rollno) {
		
		dio.deleteRecord(rollno);
		
	}

	@Override
	public Student editStudent(int rollno) {
		Student s=dio.editStudent(rollno);
		return s;
	}

	@Override
	public void updateStudent(Student s) 
	{
	
		dio.updateStudent(s);
		
	}

}
