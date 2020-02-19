package com.cjc.daoI;

import java.util.List;

import com.cjc.model.Student;

public interface DaoInterface
{
	public int saveData(Student s);
    public List<Student> getalldata(String username, String password);
    public void delete(int rollno);
    public void update(int rollno);
    public List<Student>getall();
    public Student edit(int rollno);
    
}
