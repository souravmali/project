package com.cjc.CRUD_MVC.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.CRUD_MVC.ServiceImplimentation.Service_Impl;
import com.cjc.CRUD_MVC.ServiceInterface.Service_Inter;
import com.cjc.CRUD_MVC.model.Student;
@WebServlet(urlPatterns="/delete")
public class DeleteController extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Service_Inter ser = new Service_Impl() ;
		int rollno =Integer.parseInt(req.getParameter("rollno"));
		System.out.println(rollno);
		ser.deleteRecord(rollno);
		List<Student> sl=ser.getAll();
		
		req.setAttribute("data", sl);
		RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
		rd.forward(req, resp);

	}
}
