package com.agencyapp.dao.properties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencyapp.model.properties.PropertiesTypesEntity;

@Repository
public interface PropertiesTypeDao extends JpaRepository<PropertiesTypesEntity, Integer>{

}
