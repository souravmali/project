package com.servlet1.cjc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cjc.Employee;
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee e=new Employee();
		
		int eid=Integer.parseInt(request.getParameter("eid"));
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		//e.setEid(Integer.parseInt(request.getParameter("eid")));
		
		e.setEid(eid);
		e.setName(name);
		e.setAddress(address);
		e.setEmail(email);
		e.setUname(uname);
		e.setPass(pass);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			String sql="update employee set name=?,address=?,email=?,uname=?,pass=? where eid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getAddress());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getUname());
			ps.setString(5, e.getPass());
			ps.setInt(6, e.getEid());
			ps.executeUpdate();
			System.out.println("done");
			
			
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
			
			//response.sendRedirect("login.jsp");
			
			request.setAttribute("data", list);
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			//response.sendRedirect("login.jsp");
			
			
		} catch (Exception ee) {
			
		}
		


	}

}
