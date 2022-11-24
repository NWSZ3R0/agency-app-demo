package com.agencyapp.dao.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agencyapp.model.system.ProvincesEntity;

@Repository
public interface ProvincesDao extends JpaRepository<ProvincesEntity, Integer>{
	@Query(value = "SELECT * FROM `provinces` as p WHERE p.country_id = :idP", nativeQuery = true)
	List<ProvincesEntity> findByCountryID(@Param("idP") int id);
}
