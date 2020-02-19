package com.cjc.Crud_Mvc.Dao_Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cjc.Crud_Mvc.Dao_Interface.Dao_Interface;
import com.cjc.Crud_Mvc.model.Employee;

public class Dao_impl implements Dao_Interface
{

	@Override
	public void SaveEmployeee(Employee e) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
		
			String sql="insert into employee values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, e.getEid());
			ps.setString(2, e.getName());
			ps.setString(3, e.getAddress());
			ps.setString(4, e.getGender());
			ps.setString(5, e.getDept());
			ps.setLong(6, e.getMobno());
			ps.setString(7, e.getEmail());
			ps.setString(8, e.getDoj());
			ps.setDouble(9, e.getSalary());
			ps.setString(10, e.getUname());
			ps.setString(11, e.getPass() );
			
			ps.executeUpdate();
			
			
		}catch(Exception ee)
		{
			ee.printStackTrace();
			System.out.println(ee.getMessage());
		}
		
	}
@Override
public List<Employee> getAlldata() 
	{
		List<Employee> list=new ArrayList<>();
		try
		 {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
			String sql="select *from employee";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Employee e=new Employee();
				e.setEid(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAddress(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setDept(rs.getString(5));
				e.setMobno(rs.getLong(6));
				e.setEmail(rs.getString(7));
				e.setDoj(rs.getString(8));
				e.setSalary(rs.getDouble(9));
				e.setUname(rs.getString(10));
				e.setPass(rs.getString(11));
				list.add(e);
				}
		 }
		catch (Exception e1) 
		{
	     e1.printStackTrace();
		System.out.println(e1.getMessage());
	}
   return list;
}
@Override
public List<Employee> loginEmployee(String uname, String pass)
{
	List<Employee> list=new ArrayList<Employee>();
	if(uname.equals("admin")&&pass.equals("admin"))
	{
		List<Employee>list1=getAlldata();
		return list1;
	}
	
	else
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
			String sql="select * from employee where uname=? and pass=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Employee e=new Employee();
				
				e.setEid(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAddress(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setDept(rs.getString(5));
				e.setMobno(rs.getLong(6));
				e.setEmail(rs.getString(7));
				e.setDoj(rs.getString(8));
				e.setSalary(rs.getDouble(9));
				e.setUname(rs.getString(10));
				e.setPass(rs.getString(11));
				list.add(e);
			}
		}
		
		catch(Exception e1)
		{
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
	}
	return list;
}
@Override
public void deleteEmployee(int eid) {
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
		
        String sql="delete from employee where eid=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, eid);
		ps.execute();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
}
@Override
public Employee editEmployee(int eid) {
	Employee e=new Employee();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
		String sql="select * from employee where eid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, eid);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			e.setEid(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setAddress(rs.getString(3));
			e.setGender(rs.getString(4));
			e.setDept(rs.getString(5));
			e.setMobno(rs.getLong(6));
			e.setEmail(rs.getString(7));
			e.setDoj(rs.getString(8));
			e.setSalary(rs.getDouble(9));
			e.setUname(rs.getString(10));
			e.setPass(rs.getString(11));
		}
	}catch(Exception ee)
	{
		ee.printStackTrace();
		System.out.println(ee.getMessage());
	}
	return e;
}
@Override
public void updateEmployee(Employee e) {
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
		String sql="update employee set name=?,address=?,gender=?,dept=?,mobno=?,email=?,doj=?,salary=?,uname=?,pass=? where eid=?";
		PreparedStatement ps=con.prepareStatement(sql);
	
		
		ps.setString(1, e.getName());
		ps.setString(2, e.getAddress());
		ps.setString(3, e.getGender());
		ps.setString(4, e.getDept());
		ps.setLong(5, e.getMobno());
		ps.setString(6, e.getEmail());
		ps.setString(7, e.getDoj());
		ps.setDouble(8, e.getSalary());
		ps.setString(9, e.getUname());
		ps.setString(10, e.getPass() );
		ps.setInt(11, e.getEid());
		
		ps.execute();
	}
	
	
	catch (Exception ee)
	{
	ee.printStackTrace();
	System.out.println(ee.getMessage());
	}
	
}
}

