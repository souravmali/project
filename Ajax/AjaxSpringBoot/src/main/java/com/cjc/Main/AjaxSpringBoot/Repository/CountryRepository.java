package com.cjc.Main.AjaxSpringBoot.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.Main.AjaxSpringBoot.Model.Country;
import com.cjc.Main.AjaxSpringBoot.Model.State;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer>
{
	
	public List<State> findAllByCountry_Cid(int cid);
	

}
