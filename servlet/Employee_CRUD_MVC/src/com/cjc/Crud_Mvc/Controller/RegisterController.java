
package com.cjc.Crud_Mvc.Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjc.Crud_Mvc.Service_Impl.ServiceImpl;
import com.cjc.Crud_Mvc.Service_Interface.ServiceInterface;
import com.cjc.Crud_Mvc.model.Employee;
@WebServlet(urlPatterns="/reg")
public class RegisterController extends HttpServlet
{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	ServiceInterface ser=new ServiceImpl();
	Employee e=new Employee();
	e.setEid(Integer.parseInt(request.getParameter("eid")));
	e.setName(request.getParameter("name"));
	e.setAddress(request.getParameter("address"));
	e.setGender(request.getParameter("gender"));
	//e.setDept(request.getParameter("dept"));
	
	String dept[]=request.getParameterValues("dept");
	String deps=" ";
	for(String s1:dept)
	{
		deps=deps+s1+",";
		
	}
	e.setDept(deps);
	
	e.setMobno(Long.parseLong(request.getParameter("mobno")));
	e.setEmail(request.getParameter("email"));
	//e.setDoj(Integer.parseInt(request.getParameter("doj")));
	e.setDoj(request.getParameter("doj"));
	//e.setDoj(Date.valueOf(request.getParameter("doj")));
	e.setSalary(Double.parseDouble(request.getParameter("salary")));
	e.setUname(request.getParameter("uname"));
	e.setPass(request.getParameter("pass"));
	
	ser.SaveEmployeee(e);

	response.sendRedirect("login.html");
}
}
