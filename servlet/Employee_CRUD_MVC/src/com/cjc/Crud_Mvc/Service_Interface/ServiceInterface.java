package com.cjc.Crud_Mvc.Service_Interface;
import java.util.List;
import com.cjc.Crud_Mvc.model.Employee;
public interface ServiceInterface 
{
	public void SaveEmployeee(Employee e);
	public List<Employee> getAlldata();
	public List<Employee> loginEmployee(String uname,String pass);
	public void deleteEmployee(int eid);
	public  Employee editEmployee(int eid);
	public void updateEmployee(Employee e);
}
