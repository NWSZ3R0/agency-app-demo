package com.agencyapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencyapp.dao.system.ProvincesDao;
import com.agencyapp.model.system.ProvincesEntity;
import com.agencyapp.service.IProvincesService;
@Service
public class ProvincesServiceImpl implements IProvincesService{
	@Autowired
	private ProvincesDao provincesDao;
	@Override
	public List<ProvincesEntity> getAllProvinces() {
		return provincesDao.findAll();
	}
	@Override
	public List<ProvincesEntity> findByCountryID(int id) {		
		return provincesDao.findByCountryID(id);
	}

}
