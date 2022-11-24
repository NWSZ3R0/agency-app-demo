package com.agencyapp.controller.iam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.agencyapp.dto.ResponseObjectDTO;
import com.agencyapp.model.iam.AgenciesEntity;
import com.agencyapp.service.IAgenciesService;

@RestController
public class AgenciesController {
	@Autowired
	private IAgenciesService iAgencyService;
	// Get all agencies
	@GetMapping(value = "/agencies")
	public ResponseEntity<ResponseObjectDTO> getAllAgency() {
		List<AgenciesEntity> agencyList = iAgencyService.getAllAgency();
		if(agencyList != null) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObjectDTO("ok","Querry successfully",agencyList));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObjectDTO("failed","Cannot find agency",""));
		}
		
	}
	// Get agency by id
	@GetMapping(value = "/agencies/{id}")
	public ResponseEntity<ResponseObjectDTO> getUserById(@PathVariable("id") int id) {
		AgenciesEntity agencyFound = iAgencyService.getAgencyById(id);
		if(agencyFound != null) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObjectDTO("ok","Querry successfully",agencyFound));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObjectDTO("failed","Cannot find agency with id= "+id,""));
		}
		
	}
}
