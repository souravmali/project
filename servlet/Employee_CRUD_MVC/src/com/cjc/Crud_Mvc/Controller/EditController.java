package com.cjc.Crud_Mvc.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.Crud_Mvc.Service_Impl.ServiceImpl;
import com.cjc.Crud_Mvc.Service_Interface.ServiceInterface;
import com.cjc.Crud_Mvc.model.Employee;
@WebServlet(urlPatterns="/update")
public class EditController extends HttpServlet
{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServiceInterface ser=new ServiceImpl();
	int eid=Integer.parseInt(request.getParameter("eid"));
	System.out.println(eid);
	
	Employee e=ser.editEmployee(eid);
	
	request.setAttribute("data", e);
	RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
	rd.forward(request, response);
}
}
