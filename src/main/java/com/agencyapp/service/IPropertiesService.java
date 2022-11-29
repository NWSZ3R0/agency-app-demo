package com.agencyapp.service;

import java.util.List;

import com.agencyapp.model.messaging.MessagesEntity;
import com.agencyapp.model.properties.PropertiesEntity;
import com.agencyapp.model.system.ProvincesEntity;

public interface IPropertiesService {
	public List<PropertiesEntity> getAllProperties();
	public PropertiesEntity getPropertiesById(int id);
	public PropertiesEntity addProperties(PropertiesEntity propertiesEntity);
	public PropertiesEntity updateProperties(int id,PropertiesEntity propertiesEntity);
	public boolean deleteProperties(int id);
	List<PropertiesEntity> findByPrice(Long price);
	List<PropertiesEntity> findByBaths(int baths);
	List<PropertiesEntity> findByBeds(int beds);
	List<PropertiesEntity> findByPropertyTypes(int propertyTypes);
}
