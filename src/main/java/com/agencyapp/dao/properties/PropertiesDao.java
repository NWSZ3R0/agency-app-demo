package com.agencyapp.dao.properties;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agencyapp.model.properties.PropertiesEntity;

public interface PropertiesDao extends JpaRepository<PropertiesEntity, Integer>{
	public PropertiesEntity findById(int id);
	@Query(value = "SELECT * FROM properties WHERE price_sale <= :priceP", nativeQuery = true)
	List<PropertiesEntity> findByPropertyByPrice(@Param("priceP") Long price);
	List<PropertiesEntity> findByBaths(int baths);
	List<PropertiesEntity> findByBeds(int beds);
	@Query(value = "SELECT * FROM `properties` as p WHERE p.type_id = :typeP", nativeQuery = true)
	List<PropertiesEntity> findByTypeId(@Param("typeP")int propertyTypes);
}
