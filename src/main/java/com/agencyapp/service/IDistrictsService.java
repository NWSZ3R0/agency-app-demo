package com.agencyapp.service;

import java.util.List;

import com.agencyapp.model.system.DistrictsEntity;

public interface IDistrictsService {
	public List<DistrictsEntity> getAllDistricts();
	List<DistrictsEntity> findByProvincesID(int id);
}
