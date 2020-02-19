package com.servlet1.cjc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.cjc.Employee;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id=Integer.parseInt(request.getParameter("eid"));
	System.out.println(id);
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		String sql="select * from employee where eid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		Employee ee=new Employee();
		while(rs.next())
		{
			ee.setEid(rs.getInt(1));
			ee.setName(rs.getString(2));
			ee.setAddress(rs.getString(3));
			ee.setEmail(rs.getString(4));
			ee.setUname(rs.getString(5));
			ee.setPass(rs.getString(6));
		}
		
		request.setAttribute("e", ee);
		request.getRequestDispatcher("update.jsp").forward(request, response);
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}
}
