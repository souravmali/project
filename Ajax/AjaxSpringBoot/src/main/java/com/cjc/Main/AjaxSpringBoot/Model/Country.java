package com.cjc.Main.AjaxSpringBoot.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Country 
{
	@Id
	private int cid;
	private String cname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cid")
	Set<State> state=new HashSet<>();
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<State> getState() {
		return state;
	}

	public void setState(Set<State> state) {
		this.state = state;
	}
	
	
	
	
	
}
