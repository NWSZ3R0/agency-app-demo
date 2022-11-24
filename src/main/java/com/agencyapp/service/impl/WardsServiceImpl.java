package com.agencyapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencyapp.dao.system.WardsDao;
import com.agencyapp.model.system.WardsEntity;
import com.agencyapp.service.IWardsService;
@Service
public class WardsServiceImpl implements IWardsService{
	@Autowired
	private WardsDao wardsDao;
	@Override
	public List<WardsEntity> getAllWards() {
		return wardsDao.findAll();
	}

	@Override
	public List<WardsEntity> findByDistrictsID(int id) {
		return wardsDao.findByDistrictsID(id);
	}
}
