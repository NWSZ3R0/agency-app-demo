package com.agencyapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencyapp.dao.system.DistrictsDao;
import com.agencyapp.model.system.DistrictsEntity;
import com.agencyapp.service.IDistrictsService;

@Service
public class DistrictsServiceImpl implements IDistrictsService{
	@Autowired
	private DistrictsDao districtsDao;
	@Override
	public List<DistrictsEntity> getAllDistricts() {
		return districtsDao.findAll();
	}

	@Override
	public List<DistrictsEntity> findByProvincesID(int id) {
		return districtsDao.findByProvincesID(id);
	}

}
