package com.cjc.Crud_Mvc.Service_Impl;

import java.util.List;

import com.cjc.Crud_Mvc.Dao_Impl.Dao_impl;
import com.cjc.Crud_Mvc.Dao_Interface.Dao_Interface;
import com.cjc.Crud_Mvc.Service_Interface.ServiceInterface;
import com.cjc.Crud_Mvc.model.Employee;

public class ServiceImpl implements ServiceInterface
{
    Dao_Interface dio=new Dao_impl();
	@Override
	public void SaveEmployeee(Employee e) {
		
		dio.SaveEmployeee(e);
	}
	@Override
	public List<Employee> getAlldata() {
		List<Employee> list=dio.getAlldata();
		return list;
	}
	@Override
	public List<Employee> loginEmployee(String uname, String pass) {
		List<Employee> list=dio.loginEmployee(uname, pass);
		return list;
	}
	@Override
	public void deleteEmployee(int eid) {
		
		dio.deleteEmployee(eid);
	}
	@Override
	public Employee editEmployee(int eid) {
		Employee e=dio.editEmployee(eid);
		return e;
	}
	@Override
	public void updateEmployee(Employee e) {
		dio.updateEmployee(e);
		
	}

}
