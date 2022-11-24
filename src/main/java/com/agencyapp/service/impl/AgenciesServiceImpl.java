package com.agencyapp.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencyapp.dao.iam.AgenciesDao;
import com.agencyapp.model.iam.AgenciesEntity;
import com.agencyapp.service.IAgenciesService;

@Service
public class AgenciesServiceImpl implements IAgenciesService{
	private static final Logger logger = LoggerFactory.getLogger(AgenciesServiceImpl.class);
	@Autowired
	private AgenciesDao agencyDao;
	@Autowired
	EntityManager em;
	@Override
	public List<AgenciesEntity> getAllAgency() {	
		return agencyDao.findAll();
	}
	@Override
	public AgenciesEntity getAgencyById(int id) {
		AgenciesEntity agency = new AgenciesEntity();
		agency = agencyDao.findByid(id);
//		logger.info(agency+" saas");
		return agency;
	}
	
	
}
