package com.cjc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllerUI 
{
	@RequestMapping("/")
	public String getData()
	{
		return "Registration";
	}

}
 