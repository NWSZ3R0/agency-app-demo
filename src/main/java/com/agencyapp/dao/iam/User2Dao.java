package com.agencyapp.dao.iam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agencyapp.dto.ReponseUserAgencyDTO;
import com.agencyapp.model.iam.UsersEntity;

@Repository
public interface User2Dao extends JpaRepository<UsersEntity, Integer>{
	public UsersEntity findByid(int id);
	public UsersEntity findByUsername(String username);
	@Query(value = "SELECT u.id AS id,a.name AS agency_name ,u.username AS username, u.first_name, u.last_name AS last_name, u.email, u.password, u.job_title, u.created, u.updated from users u INNER JOIN agencies a ON a.id = u.agency_id where u.username = :usernameP", nativeQuery = true)
	ReponseUserAgencyDTO getUserDTO(@Param("usernameP") String username);
}
