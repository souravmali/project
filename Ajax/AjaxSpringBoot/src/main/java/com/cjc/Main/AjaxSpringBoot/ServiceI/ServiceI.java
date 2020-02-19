package com.cjc.Main.AjaxSpringBoot.ServiceI;

import java.util.List;
import java.util.Set;

import com.cjc.Main.AjaxSpringBoot.Model.City;
import com.cjc.Main.AjaxSpringBoot.Model.Country;
import com.cjc.Main.AjaxSpringBoot.Model.State;

public interface ServiceI 
{
	public List<Country> getCountryList();
	public List<State> getStateList(int cid);
	public List<City> getCityList(int sid);

}
