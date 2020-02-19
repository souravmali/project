package com.cjc.CRUD_MVC.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.CRUD_MVC.ServiceImplimentation.Service_Impl;
import com.cjc.CRUD_MVC.ServiceInterface.Service_Inter;
import com.cjc.CRUD_MVC.model.Student;
@WebServlet(urlPatterns="/edit")
public class EditController extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Service_Inter ser=new Service_Impl();
		int rollno=Integer.parseInt(req.getParameter("rollno"));
		System.out.println(rollno);
		Student s=ser.editStudent(rollno);
		
		
		req.setAttribute("data", s);
		RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
		rd.forward(req, resp);

	}
}
