package com.cjc.Main.AjaxSpringBoot.ServiceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.Main.AjaxSpringBoot.Model.City;
import com.cjc.Main.AjaxSpringBoot.Model.Country;
import com.cjc.Main.AjaxSpringBoot.Model.State;
import com.cjc.Main.AjaxSpringBoot.Repository.CityRepository;
import com.cjc.Main.AjaxSpringBoot.Repository.CountryRepository;
import com.cjc.Main.AjaxSpringBoot.Repository.StateRepository;
import com.cjc.Main.AjaxSpringBoot.ServiceI.ServiceI;

@Service
public class ServiceImpl implements ServiceI {
	@Autowired
	CountryRepository cr;

	@Autowired
	StateRepository sr;

	@Autowired
	CityRepository cityRep;

	@Override
	public List<Country> getCountryList() {
		System.out.println("in serviceImpl getcountry method");

		List<Country> li = (List<Country>) cr.findAll();
		System.out.println(li);
		return li;
	}

	@Override
	public List<State> getStateList(int cid) 
	{
		System.out.println(cid);
		System.out.println("in getStateList");
	 List<State> statelist= cr.findAllByCountry_Cid(cid);
		
	
		
		
		return statelist;
	}

	@Override
	public List<City> getCityList(int sid) 
	{
		List<City>citylist=sr.findAllByState_Sid(sid);

		return citylist;
	}

}
