package com.agencyapp.controller.properties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agencyapp.dto.ResponseObjectDTO;
import com.agencyapp.model.iam.UsersEntity;
import com.agencyapp.model.properties.PropertiesEntity;
import com.agencyapp.model.properties.PropertiesSubtypesEntity;
import com.agencyapp.model.properties.PropertiesTypesEntity;
import com.agencyapp.service.IPropertiesService;
import com.agencyapp.service.IPropertiesSubTypeService;
import com.agencyapp.service.IPropertiesTypeService;

@RestController
public class PropertiesController {
	@Autowired
	private IPropertiesTypeService iPropertyTypeService;
	@Autowired
	private IPropertiesSubTypeService iPropertySubTypeService;
	@Autowired
	private IPropertiesService iPropertiesService;

	// Get all properties type
	@GetMapping(value = "/types")
	public ResponseEntity<ResponseObjectDTO> getAllPropertyTypesController() {
		List<PropertiesTypesEntity> propertyTypeList = iPropertyTypeService.getAllPropertyTypes();
		if (propertyTypeList != null && propertyTypeList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObjectDTO("ok", "Querry successfully", propertyTypeList));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObjectDTO("failed", "Cannot find property type", ""));
		}

	}

	// Get all properties subtype
	@GetMapping(value = "/subtypes")
	public ResponseEntity<ResponseObjectDTO> getAllPropertySubTypesController() {
		List<PropertiesSubtypesEntity> propertySubTypeList = iPropertySubTypeService.getAllPropertySubTypes();
		if (propertySubTypeList != null && propertySubTypeList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObjectDTO("ok", "Querry successfully", propertySubTypeList));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObjectDTO("failed", "Cannot find property type", ""));
		}
	}

	// Get all system subtypes from its parent property type
	@GetMapping(value = "/subtypesByPropertiesTypeID/{id}")
	public ResponseEntity<ResponseObjectDTO> getAllPropertySubTypesControllerByPropertiesTypeId(
			@PathVariable("id") int id) {
		List<PropertiesSubtypesEntity> propertySubTypeByPropertiesIdList = iPropertySubTypeService
				.findByPropertyTypeId(id);
		if (propertySubTypeByPropertiesIdList != null && propertySubTypeByPropertiesIdList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObjectDTO("ok", "Querry successfully", propertySubTypeByPropertiesIdList));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObjectDTO("failed", "Cannot find property type", ""));
		}
	}

	// Get property by id
	@GetMapping(value = "/properties/{id}")
	public ResponseEntity<ResponseObjectDTO> getPropertiesById(@PathVariable("id") int id) {
		PropertiesEntity propertyfound = iPropertiesService.getPropertiesById(id);
		if (propertyfound != null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObjectDTO("ok", "Querry successfully", propertyfound));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObjectDTO("failed", "Cannot find property with id= " + id, ""));
		}
	}

	// Get all property
	@GetMapping(value = "/properties")
	public ResponseEntity<ResponseObjectDTO> getAllProperties() {
		List<PropertiesEntity> propertyfound = iPropertiesService.getAllProperties();
		if (propertyfound != null && propertyfound.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObjectDTO("ok", "Querry successfully", propertyfound));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObjectDTO("failed", "Cannot find property ", ""));
		}
	}

	@PostMapping(value = "/properties/add")
	public ResponseEntity<ResponseObjectDTO> addProperties(@RequestBody PropertiesEntity propertiesEntity) {
		if (propertiesEntity != null) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObjectDTO("ok", "Insert successfully",
					iPropertiesService.addProperties(propertiesEntity)));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObjectDTO("failed", "Cannot insert property", ""));
		}
	}

	@PutMapping(value = "/properties/update/{id}")
	public ResponseEntity<ResponseObjectDTO> updateProperties(@PathVariable("id") int id,
			@RequestBody PropertiesEntity propertiesEntity) {
		PropertiesEntity propertiesUpdated = iPropertiesService.updateProperties(id, propertiesEntity);
		if (propertiesUpdated != null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObjectDTO("ok", "Update successfully", propertiesUpdated));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObjectDTO("failed", "Cannot update user id = " + id, ""));
		}
	}

	@DeleteMapping(value = "/properties/delete/{id}")
	public ResponseEntity<ResponseObjectDTO> deleteProperties(@PathVariable("id") int id) {
		if (iPropertiesService.deleteProperties(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObjectDTO("ok", "Delete successfully", ""));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObjectDTO("failed", "Cannot delete properties id = " + id, ""));
		}
	}

	@GetMapping(value = "/properties/results")
	public ResponseEntity<ResponseObjectDTO> getSearchProperties(@RequestParam("search_query") long search_query,
			@RequestParam("sp") String nameSearch) {
		if (nameSearch.equalsIgnoreCase("price")) {
			List<PropertiesEntity> propertyfound = iPropertiesService.findByPrice(search_query);
			if (propertyfound != null && propertyfound.size() > 0) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ResponseObjectDTO("ok", "Querry successfully", propertyfound));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponseObjectDTO("failed", "Cannot find property ", ""));
			}
		}else if (nameSearch.equalsIgnoreCase("baths")) {
			List<PropertiesEntity> propertyfound = iPropertiesService.findByBaths((int)search_query);
			if (propertyfound != null && propertyfound.size() > 0) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ResponseObjectDTO("ok", "Querry successfully", propertyfound));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponseObjectDTO("failed", "Cannot find property ", ""));
			}
		}else if (nameSearch.equalsIgnoreCase("beds")) {
			List<PropertiesEntity> propertyfound = iPropertiesService.findByBeds((int)search_query);
			if (propertyfound != null && propertyfound.size() > 0) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ResponseObjectDTO("ok", "Querry successfully", propertyfound));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponseObjectDTO("failed", "Cannot find property ", ""));
			}
		}else if (nameSearch.equalsIgnoreCase("property_types")) {
			List<PropertiesEntity> propertyfound = iPropertiesService.findByPropertyTypes((int)search_query);
			if (propertyfound != null && propertyfound.size() > 0) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ResponseObjectDTO("ok", "Querry successfully", propertyfound));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponseObjectDTO("failed", "Cannot find property ", ""));
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ResponseObjectDTO("failed", "Wrong param sp", ""));
	}
}
