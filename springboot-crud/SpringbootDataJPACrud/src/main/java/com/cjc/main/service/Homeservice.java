package com.cjc.main.service;

import java.util.List;
import java.util.Optional;

import com.cjc.main.model.Employee;

public interface Homeservice 
{
	public void savedata(Employee e);
	public List<Employee> logincheck(String uname, String pass);
	public void DeleteRecord(int eid);
	 public List<Employee> getAlldata();
	 public Employee editEmployee(int eid); 
	 public void updateEmployee(Employee e);

}
