package com.cjc.Main.AjaxSpringBoot.Controller;

import java.util.List;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjc.Main.AjaxSpringBoot.Model.City;
import com.cjc.Main.AjaxSpringBoot.Model.Country;
import com.cjc.Main.AjaxSpringBoot.Model.State;
import com.cjc.Main.AjaxSpringBoot.ServiceI.ServiceI;
import com.google.gson.Gson;

@Controller
public class HomeController {
	@Autowired
	ServiceI si;

	@RequestMapping("/")
	public String LandingPage() {
		return "Login";

	}

	@RequestMapping("/country")
	public @ResponseBody String CountryList() {
		System.out.println("in country action");
		List<Country> countrylist = si.getCountryList();

		Gson g = new Gson();
		String json = g.toJson(countrylist);

		return json;

	}

	@RequestMapping("/state/{cid}")
	public @ResponseBody String StateList(@PathVariable(name="cid")int cid) 
	{
		System.out.println("In GetStateList method!!");
		List<State> statelist = si.getStateList(cid);

		Gson g = new Gson();
		String json = g.toJson(statelist);

		return json;

	}

	@RequestMapping("/city/{sid}")
	public @ResponseBody String CityList(@PathVariable(name="sid") int sid) 
	{
		System.out.println("In CityList method");
		
		List<City> citylist = si.getCityList(sid);

		Gson g = new Gson();
		String json = g.toJson(citylist);

		return json;

	}

}
