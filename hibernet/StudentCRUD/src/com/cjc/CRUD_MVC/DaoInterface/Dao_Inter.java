package com.cjc.CRUD_MVC.DaoInterface;

import java.util.List;

import com.cjc.CRUD_MVC.model.Student;

public interface Dao_Inter 
{

	public void saveStudent (Student s) ;
	
	public List<Student> logincheck(String username, String password);

	public List<Student> getAll();
	
	public void deleteRecord(int rollno);
	
	public Student editStudent(int rollno);
	
	public void updateStudent(Student s);


}
