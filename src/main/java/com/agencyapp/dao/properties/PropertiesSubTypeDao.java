package com.agencyapp.dao.properties;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agencyapp.model.properties.PropertiesSubtypesEntity;
@Repository
public interface PropertiesSubTypeDao extends JpaRepository<PropertiesSubtypesEntity, Integer>{
	@Query(value = "SELECT * FROM `property_subtypes` as p WHERE p.property_type_id = :idP", nativeQuery = true)
	List<PropertiesSubtypesEntity> findByPropertyTypeId(@Param("idP") int id);
}

