package com.servlet1.cjc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.cjc.Employee;


@WebServlet(urlPatterns="/reg")
public class RegisterSrevlet extends HttpServlet 
{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Employee e=new Employee();
	
	/*int eid=Integer.parseInt(request.getParameter("eid"));
	String name=request.getParameter("name");
	String address=request.getParameter("addr");
	String email=request.getParameter("email");
	String uname=request.getParameter("uname");
	String pass=request.getParameter("pass");
	e.setEid(eid);
	*/
	e.setEid(Integer.parseInt(request.getParameter("eid")));
	e.setName(request.getParameter("name"));
	e.setAddress(request.getParameter("addr"));
	e.setEmail(request.getParameter("email"));
	e.setUname(request.getParameter("uname"));
	e.setPass(request.getParameter("pass"));
	

	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			String sql="insert into employee values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, e.getEid());
			ps.setString(2,e.getName() );
			ps.setString(4, e.getEmail());
			ps.setString(3, e.getAddress() );
			ps.setString(5, e.getUname());
			ps.setString(6, e.getPass());
			
			ps.executeUpdate();
			ps.close();
			con.close();
		response.sendRedirect("login.jsp");
			
		}
		catch (ClassNotFoundException e1)
		{
			e1.printStackTrace();
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		

	
	
}
}
