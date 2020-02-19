package com.servlet1.cjc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cjc.Employee;

@WebServlet(urlPatterns="/log")
public class LoginServlet extends HttpServlet

{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	List<Employee> list=new ArrayList<>();
	String username=request.getParameter("t1");
	String password=request.getParameter("t2");
	
	boolean flag=false;
	boolean temp=false;
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
		
		
		String sql="select *from employee";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				if(username.equals("admin")&&password.equals("admin"))
				{
					Employee e=new Employee();
			e.setEid(rs.getInt(1));
		       e.setName(rs.getString(2));
		       e.setAddress(rs.getString(3));
		       e.setEmail(rs.getString(4));
		       e.setUname(rs.getString(5));
		       e.setPass(rs.getString(6));
		       list.add(e);
		       flag=true;
			}
				
				if(username.equals(rs.getString(5))&&password.equals(rs.getString(6)))
				{
			       Employee e=new Employee();
			       e.setEid(rs.getInt(1));
			       e.setName(rs.getString(2));
			       e.setAddress(rs.getString(3));
			       e.setEmail(rs.getString(4));
			       e.setUname(rs.getString(5));
			       e.setPass(rs.getString(6));	
				list.add(e);
				temp=true;
				break;
	      }
			}
			if(flag==true)
			{
			request.setAttribute("data", list);
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		    
			}
			
			else if(temp==true)
			{
				request.setAttribute("data", list);
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
		
	}
			

	
	
	
	
		/*while(rs.next())
		{
			if(username.equals(rs.getString(5))&&password.equals(rs.getString(6)))
					{
				       System.out.println("Login Successiful.....");
				       e.setEid(rs.getInt(1));
				       e.setName(rs.getString(2));
				       e.setAddress(rs.getString(3));
				       e.setEmail(rs.getString(4));
				       e.setUname(rs.getString(5));
				       e.setPass(rs.getString(6));
				       
				       list.add(e);
				       flag=true;
				       break;
				       
					}
			
			if(flag=true)
			{
				request.setAttribute("data", list);
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			
			else
			{
		
				request.setAttribute("msg", "invalid login & Psaaword..");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
	}*/
	catch (SQLException e1)
	{
		
		e1.printStackTrace();
	}
	catch (ClassNotFoundException e1) 
	{
	e1.printStackTrace();
	}
	
	

	
}
}