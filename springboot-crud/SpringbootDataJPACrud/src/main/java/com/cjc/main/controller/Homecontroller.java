package com.cjc.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.model.Employee;
import com.cjc.main.service.Homeservice;

@Controller
public class Homecontroller
{
	@Autowired
	Homeservice hs;
	
	
	@RequestMapping("/")
	public String prelogin() 
	{
		return"index";
		
	}
	@RequestMapping("/reg")
	public String registeruser(@ModelAttribute Employee e)
	{
	hs.savedata(e);
		
			return "index";
				
	}
	
	@RequestMapping("/log")
	public String logincheck(@RequestParam("username") String uname,@RequestParam("password")String pass,Model m)
	{
		 System.out.println(uname);
	     System.out.println(pass);
		List<Employee> list= hs.logincheck(uname,pass);
		if(!list.isEmpty())
		{
		m.addAttribute("data",list);
		 return "success";
		
		}
		else
		{
			m.addAttribute("msg" ,"Invalid");
			return "index";
		}
	 }
	 
	 @RequestMapping("/delete")
		public String del(@RequestParam("eid") int eid,Model m)
		{
			 System.out.println(eid);
			 hs.DeleteRecord(eid);
			 
			 List<Employee>l=hs.getAlldata();
			 m.addAttribute("data",l);
			 
			 
			return "success";
			
		}
	 @RequestMapping("/edit")
	 public String ed(@RequestParam("eid") int eid,Model m)
	 {
		 System.out.println(eid);
		 hs.editEmployee(eid);
		  Employee emp=hs.editEmployee(eid);
		 m.addAttribute("data",emp);
		return "update";
		 
	 }

	 @RequestMapping("/update")
	 public String up(@ModelAttribute Employee e, Model m)
	 {
		
		hs.updateEmployee(e);
	
		 List<Employee> l=hs.getAlldata();
		 m.addAttribute("data",l);
		return "success";
		 
	 }

}
