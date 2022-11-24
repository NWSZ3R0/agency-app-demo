package com.agencyapp.dao.properties;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agencyapp.model.properties.PropertiesEntity;

public interface PropertiesDao extends JpaRepository<PropertiesEntity, Integer>{
	public PropertiesEntity findById(int id);
}
