package com.agencyapp.service;

import java.util.List;

import com.agencyapp.model.system.ProvincesEntity;

public interface IProvincesService {
	public List<ProvincesEntity> getAllProvinces();
	List<ProvincesEntity> findByCountryID(int id);
}
