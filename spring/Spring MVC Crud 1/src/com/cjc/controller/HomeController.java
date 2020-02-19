	package com.cjc.controller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.model.Student;
    import com.cjc.servicel.ServiceInterface;
	

	@Controller
	public class HomeController
	{
		@Autowired
		ServiceInterface serv;
		
		@RequestMapping("/")
		public String m1()
		{
			return "login";
		}
		
		@RequestMapping("/register")
		public String register()
		{
		  System.out.println("in register method");
		  return "register";
		}
		
		@RequestMapping("/reg")
		public String m2(@ModelAttribute Student s)
		{
			
			System.out.println(s.getRollno());
			System.out.println(s.getName());
			System.out.println(s.getAddress());
			System.out.println(s.getUsername());
			System.out.println(s.getPassword());
			int i = serv.saveData(s);
			if(i>0)
			{
				System.out.println("Data Inserted");
			    return "login";
			}
			else
				return "register";
		}
		@RequestMapping("/delete")
		public String deleterecord(@RequestParam("rollno")int rollno,Model m)
		{
		   System.out.println(rollno);
		   serv.delete(rollno);
		   List<Student> st=serv.getall();
		   m.addAttribute("data",st );
		   return "success";
		  
		}
		@RequestMapping("/edit")
		public String editrecord(@RequestParam("rollno")int rollno,Model m)
		{
			Student s=serv.edit(rollno);
			m.addAttribute("data", s);
			return "update";
		}
		@RequestMapping("/update")
		public String updaterecord(@RequestParam("rollno")int rollno,Model m)
		{
			System.out.println(rollno);
			serv.update(rollno);
			List<Student>st=serv.getall();
			m.addAttribute("data", st);
			return "success";
		}
		@RequestMapping("/log")
		public String LoginUser(@RequestParam("username") String username, @RequestParam("password") String password, Model m )
		{
			
		  List<Student> li= serv.getalldata(username,password);
		  
		  m.addAttribute("data", li);
		   
			return "success";
		}
		
	    
	}

	

