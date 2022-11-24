package com.agencyapp.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencyapp.dao.properties.PropertiesDao;
import com.agencyapp.model.iam.UsersEntity;
import com.agencyapp.model.messaging.MessagesEntity;
import com.agencyapp.model.properties.PropertiesEntity;
import com.agencyapp.service.IPropertiesService;
@Service
public class PropertiesServiceImpl implements IPropertiesService{
	private SimpleDateFormat fm =new SimpleDateFormat("yyyy/MM/dd");
	@Autowired
	private PropertiesDao propertiesDao;
	@Override
	public List<PropertiesEntity> getAllProperties() {
		return propertiesDao.findAll();
	}

	@Override
	public PropertiesEntity getPropertiesById(int id) {
		return propertiesDao.findById(id);
	}

	@Override
	public PropertiesEntity addProperties(PropertiesEntity propertiesEntity) {
		try {
			propertiesEntity.setCreated(fm.parse(fm.format(new Date())));
		} catch (ParseException e) {
			System.out.println("Parse date error!");
			e.printStackTrace();
		}
		return propertiesDao.save(propertiesEntity);
	}

	@Override
	public PropertiesEntity updateProperties(int id, PropertiesEntity propertiesEntity) {
		if (propertiesEntity != null) {
			PropertiesEntity propertiesFound = propertiesDao.findById(id);
			if (propertiesFound != null) {
				propertiesFound.setAgency_id(propertiesEntity.getAgency_id());
				propertiesFound.setForSale(propertiesEntity.isForSale());
				propertiesFound.setForRentLong(propertiesEntity.isForRentLong());
				propertiesFound.setForRentShort(propertiesEntity.isForRentShort());
				propertiesFound.setPriceSale(propertiesEntity.getPriceSale());
				propertiesFound.setPriceRentLong(propertiesEntity.getPriceRentLong());
				propertiesFound.setPriceRentShort(propertiesEntity.getPriceRentShort());
				propertiesFound.setType_id(propertiesEntity.getType_id());
				propertiesFound.setSubtype_id(propertiesEntity.getSubtype_id());
				propertiesFound.setStatus(propertiesEntity.getStatus());
				propertiesFound.setFloor(propertiesEntity.getFloor());
				propertiesFound.setDescription(propertiesEntity.getDescription());
				propertiesFound.setAddress1(propertiesEntity.getAddress1());
				propertiesFound.setAddress2(propertiesEntity.getAddress2());
				propertiesFound.setCountry_id(propertiesEntity.getCountry_id());
				propertiesFound.setProvince_id(propertiesEntity.getProvince_id());
				propertiesFound.setDistrict_id(propertiesEntity.getDistrict_id());
				propertiesFound.setWard_id(propertiesEntity.getWard_id());
				propertiesFound.setCommission(propertiesEntity.getCommission());
				propertiesFound.setCommission_pct(propertiesEntity.getCommission_pct());
				propertiesFound.setCommission_list_agent(propertiesEntity.getCommission_list_agent());
				propertiesFound.setCommission_list_agent_pct(propertiesEntity.getCommission_list_agent_pct());
				propertiesFound.setCommission_sell_agent(propertiesEntity.getCommission_sell_agent());
				propertiesFound.setCommission_sell_agent_pct(propertiesEntity.getCommission_sell_agent_pct());
				propertiesFound.setBeds(propertiesEntity.getBeds());
				propertiesFound.setBaths(propertiesEntity.getBaths());
				propertiesFound.setBuilt_space(propertiesEntity.getBuilt_space());
				propertiesFound.setGarden_space(propertiesEntity.getGarden_space());
				propertiesFound.setTerrace_space(propertiesEntity.getTerrace_space());
				propertiesFound.setCurrency(propertiesEntity.getCurrency());
				propertiesFound.setDimension(propertiesEntity.getDimension());
				propertiesFound.setCreated(propertiesEntity.getCreated());
				try {
					propertiesFound.setUpdated(fm.parse(fm.format(new Date())));
				} catch (ParseException e) {
					System.out.println("Parse date error!");
					e.printStackTrace();
				}
				
				return propertiesDao.save(propertiesFound);
			}
		}
		return null;
	}

	@Override
	public boolean deleteProperties(int id) {
		if(propertiesDao.findById(id) != null) {
			propertiesDao.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
