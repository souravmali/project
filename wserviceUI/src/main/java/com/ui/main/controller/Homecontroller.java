package com.ui.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@CrossOrigin
public class Homecontroller
{
	@RequestMapping("/prelogin")
	public String prelogin()
	{
		return "index";
	}
	

}
