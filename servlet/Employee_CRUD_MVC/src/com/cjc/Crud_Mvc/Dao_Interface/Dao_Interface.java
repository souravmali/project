package com.cjc.Crud_Mvc.Dao_Interface;

import java.util.List;

import com.cjc.Crud_Mvc.model.Employee;

public interface Dao_Interface 
{
	public void SaveEmployeee(Employee e);
	public List<Employee> getAlldata();
	public List<Employee> loginEmployee(String uname,String pass);
	public void deleteEmployee(int eid);
	public  Employee editEmployee(int eid);
	public void updateEmployee(Employee e);
}
