package com.agencyapp.service;

import java.util.List;

import com.agencyapp.model.messaging.MessagesEntity;
import com.agencyapp.model.properties.PropertiesEntity;

public interface IPropertiesService {
	public List<PropertiesEntity> getAllProperties();
	public PropertiesEntity getPropertiesById(int id);
	public PropertiesEntity addProperties(PropertiesEntity propertiesEntity);
	public PropertiesEntity updateProperties(int id,PropertiesEntity propertiesEntity);
	public boolean deleteProperties(int id);
}
