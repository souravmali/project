package com.cjc.Main.AjaxSpringBoot.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class State 
{
	@Id
	private int sid;
	private String sname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="sid")
	Set<City> city=new HashSet<>();

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set<City> getCity() {
		return city;
	}

	public void setCity(Set<City> city) {
		this.city = city;
	}
	
	
	
	
}
