package com.agencyapp.service;

import java.util.List;

import com.agencyapp.model.iam.AgenciesEntity;

public interface IAgenciesService {
	public List<AgenciesEntity> getAllAgency();
	public AgenciesEntity getAgencyById(int id);
}
