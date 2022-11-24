package com.agencyapp.service;

import java.util.List;

import com.agencyapp.model.system.WardsEntity;

public interface IWardsService {
	public List<WardsEntity> getAllWards();
	List<WardsEntity> findByDistrictsID(int id);
}
