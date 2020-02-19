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
@WebServlet(urlPatterns="/delete")
public class DeleteServlet extends HttpServlet
{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Employee e=new Employee();
	
		try {
			int eid=Integer.parseInt(request.getParameter("eid"));
			e.setEid(eid);
			
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		System.out.println("Delete successful.....");
		String sql="Delete from employee where eid=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, e.getEid());
		ps.execute();
		
		
		ps=con.prepareStatement("select * from employee");
		ResultSet rs=ps.executeQuery();
		List<Employee> list=new ArrayList<Employee>();
		
		while(rs.next())
		{
			Employee e1=new Employee();
			   e1.setEid(rs.getInt(1));
		       e1.setName(rs.getString(2));
		       e1.setAddress(rs.getString(3));
		       e1.setEmail(rs.getString(4));
		       e1.setUname(rs.getString(5));
		       e1.setPass(rs.getString(6));
		       
		       list.add(e1);
		}
				ps.close();
		
		
		
		request.setAttribute("data", list);
		RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
		//response.sendRedirect("login.jsp");
		
	} 
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

