package com.cjc.main.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Employee;
import com.cjc.main.repository.Homerepository;
import com.cjc.main.service.Homeservice;

@Service
public class Homeserviceimpl implements Homeservice
{
@Autowired
Homerepository hr;
	@Override
	public void savedata(Employee e) 
	{
	  hr.save(e);
		
	}
	@Override
	public List<Employee> logincheck(String uname, String pass)
	{
		if(uname.equals("admin")&&pass.equals("admin"))
		{

			List<Employee> st=(List<Employee>)hr.findAll();
			return st;
		
		}
		else
		{
			List<Employee> list=hr.findByUsernameAndPassword(uname, pass);	
			return list;
		}
			 
	}
	@Override
	public void DeleteRecord(int eid) 
	{
		System.out.println(eid);
		hr.deleteById(eid);
		
		
		
	}
	@Override
	public List<Employee> getAlldata() {
	
		List<Employee> st=(List<Employee>)hr.findAll();
		return st;
	}
	@Override
	public Employee editEmployee(int eid) {
		System.out.println(eid);
	
	Employee emp=hr.findById(eid).get();
	
				return emp;
	}
	@Override
	public void updateEmployee(Employee e) 
	{
	
	hr.findAll();
	hr.save(e);
		
		
	}
	

}
