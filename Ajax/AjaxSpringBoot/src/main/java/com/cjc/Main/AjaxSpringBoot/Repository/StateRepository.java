package com.cjc.Main.AjaxSpringBoot.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.Main.AjaxSpringBoot.Model.City;
import com.cjc.Main.AjaxSpringBoot.Model.State;

@Repository
public interface StateRepository extends CrudRepository<State, Integer>
{
	public List<City> findAllByState_Sid(int sid);
 
}
