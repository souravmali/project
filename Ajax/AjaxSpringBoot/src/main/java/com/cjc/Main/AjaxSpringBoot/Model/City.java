package com.cjc.Main.AjaxSpringBoot.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City 
{
	@Id
	private int cityId;
	private String cityName;
	
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

}
