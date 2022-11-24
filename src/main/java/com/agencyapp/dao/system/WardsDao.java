package com.agencyapp.dao.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agencyapp.model.system.WardsEntity;
@Repository
public interface WardsDao extends JpaRepository<WardsEntity, Integer>{
	@Query(value = "SELECT * FROM wards as w WHERE w.district_id = :idP", nativeQuery = true)
	List<WardsEntity> findByDistrictsID(@Param("idP") int id);
}
