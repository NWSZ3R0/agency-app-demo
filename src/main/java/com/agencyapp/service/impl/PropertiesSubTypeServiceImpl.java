package com.agencyapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencyapp.dao.properties.PropertiesSubTypeDao;
import com.agencyapp.model.properties.PropertiesSubtypesEntity;
import com.agencyapp.service.IPropertiesSubTypeService;
@Service
public class PropertiesSubTypeServiceImpl implements IPropertiesSubTypeService{
@Autowired
	private PropertiesSubTypeDao propertiesSubTypeDao;
	@Override
	public List<PropertiesSubtypesEntity> getAllPropertySubTypes() {
		return propertiesSubTypeDao.findAll();
	}
	@Override
	public List<PropertiesSubtypesEntity> findByPropertyTypeId(int id) {
		return propertiesSubTypeDao.findByPropertyTypeId(id);
	}
	
}
