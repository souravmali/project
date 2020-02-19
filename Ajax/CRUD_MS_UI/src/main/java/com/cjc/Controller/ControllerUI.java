package com.cjc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjc.Model.Student;

@Controller
public class ControllerUI {

	@RequestMapping("/")
	public String LoginPage() {
		return "Index";

	}

	@RequestMapping("/reg")
	public String RegistrationPage() {
		return "Registration";

	}

	@RequestMapping("/edit")
	public String EditData() {
		System.out.println("edit dATA");

		return "Edit";

	}

	@RequestMapping("/postdata")
	public String getData(@RequestBody Student s) {
		System.out.println(s.getRollno());
		System.out.println(s.getName());
		System.out.println(s.getEmail());
		System.out.println(s.getPassword());

		return "Success";

	}

}
