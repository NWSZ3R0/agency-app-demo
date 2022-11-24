package com.agencyapp.dao.system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencyapp.model.properties.PropertiesTypesEntity;
import com.agencyapp.model.system.CountriesEntity;

@Repository
public interface CountriesDao extends JpaRepository<CountriesEntity, Integer>{
	
}
