package com.cjc.CRUD_MVC.Controller;

import java.io.IOException;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.CRUD_MVC.ServiceImplimentation.Service_Impl;
import com.cjc.CRUD_MVC.ServiceInterface.Service_Inter;
import com.cjc.CRUD_MVC.model.Student;

@WebServlet(urlPatterns="/log")
public class LoginController extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Service_Inter ser = new Service_Impl() ;
		
		Student s=new Student();
		String username=req.getParameter("username");
		System.out.println(username);
		String password=req.getParameter("password");
		System.out.println(password);
		
		
		List<Student> sl=ser.logincheck(username, password);
		
		if(! (sl==null))
		{
			req.setAttribute("data", sl);
			RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
			rd.forward(req, resp);
		}
		else
		{
			System.out.println("Invalid Username or Password");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
		}

	}
}
