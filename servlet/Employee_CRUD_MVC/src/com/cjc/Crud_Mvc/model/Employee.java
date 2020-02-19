package com.cjc.Crud_Mvc.model;

import java.sql.Date;

public class Employee 
{
private int eid;
private String name;
private String address;
private String gender;
private String dept;
//private String dept[];
private long mobno;
private String email;
private String doj;
//private D doj;
private double salary;
private String uname;
private String pass;
public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
	this.doj = doj;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public long getMobno() {
	return mobno;
}
public void setMobno(long mobno) {
	this.mobno = mobno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}


}
 