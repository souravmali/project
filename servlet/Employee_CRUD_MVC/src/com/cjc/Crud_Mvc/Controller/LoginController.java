package com.cjc.Crud_Mvc.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cjc.Crud_Mvc.Service_Impl.ServiceImpl;
import com.cjc.Crud_Mvc.Service_Interface.ServiceInterface;
import com.cjc.Crud_Mvc.model.Employee;
@WebServlet(urlPatterns="/log")
public class LoginController extends HttpServlet
{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServiceInterface ser=new ServiceImpl();
	String uname=request.getParameter("uname");
	String pass=request.getParameter("pass");
	
	//List<Employee> list=ser.getAlldata();
	List<Employee> l=ser.loginEmployee(uname, pass);
	
	request.setAttribute("data", l);
	RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
	rd.forward(request, response);
	
}
}
