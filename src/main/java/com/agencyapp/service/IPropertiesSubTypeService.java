package com.agencyapp.service;

import java.util.List;

import com.agencyapp.model.properties.*;

public interface IPropertiesSubTypeService {
	public List<PropertiesSubtypesEntity> getAllPropertySubTypes();
	public List<PropertiesSubtypesEntity> findByPropertyTypeId(int id);
}
