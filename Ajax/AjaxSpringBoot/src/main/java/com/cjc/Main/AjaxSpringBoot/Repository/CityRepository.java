package com.cjc.Main.AjaxSpringBoot.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.Main.AjaxSpringBoot.Model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>
{
	

}
