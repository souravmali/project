package com.cjc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.model.Employee;

@Repository
public interface Homerepository extends CrudRepository<Employee,Integer>
{
	//@Query(value="select*from Emoloyee where username=? and password=?",nativeQuery = true)
//List<Employee>findAllByUsernameAndPassword(String uname,String pass);

List<Employee> findByUsernameAndPassword(String uname, String pass);

}
