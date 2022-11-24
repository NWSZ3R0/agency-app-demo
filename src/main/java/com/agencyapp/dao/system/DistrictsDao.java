package com.agencyapp.dao.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agencyapp.model.system.DistrictsEntity;
@Repository
public interface DistrictsDao extends JpaRepository<DistrictsEntity, Integer>{
	@Query(value = "SELECT * FROM districts as d WHERE d.province_id = :idP", nativeQuery = true)
	List<DistrictsEntity> findByProvincesID(@Param("idP") int id);
}
