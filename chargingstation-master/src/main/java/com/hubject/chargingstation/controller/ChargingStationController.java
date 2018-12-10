package com.hubject.chargingstation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hubject.chargingstation.dto.ChargingStationDTO;
import com.hubject.chargingstation.dto.GeolocationDTO;
import com.hubject.chargingstation.dto.SearchDTO;
import com.hubject.chargingstation.model.ChargingStation;
import com.hubject.chargingstation.service.ChargingStationService;


/**
 * @author Vivek
 * 
 * Controller class for Charging station manipulation
 * 
 * All methods can be accessed by /chargingstation rest path
 *
 */
@RestController
@RequestMapping(value = "/chargingstation")
public class ChargingStationController {

	@Autowired
	ChargingStationService chargingStationService;
	
	/**
	 * POST rest service for saving the ChargingStation Entity
	 * 
	 * @param chargingStation
	 * @return chargingStation
	 */
	@RequestMapping(method = RequestMethod.POST , consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> save(@RequestBody(required = true) @Valid ChargingStation chargingStation) {
		chargingStation = chargingStationService.save(chargingStation);
		if(chargingStation!=null)
			return new ResponseEntity<Object>(chargingStation, HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * GET rest service to get the chargingStationDTO containing the list of Chargingstation objects meeting the query type and search text criteria
	 * query type can be one of the enum values ChargingStationEnum
	 * 
	 * @param searchDTO
	 * @return chargingStationDTO
	 */
	@RequestMapping(method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	  public ResponseEntity<Object> get(@Valid SearchDTO searchDTO) {
		ChargingStationDTO chargingStationDTO = chargingStationService.get(searchDTO);
		if(chargingStationDTO.getChargingStationList().isEmpty())
			return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(chargingStationDTO, HttpStatus.OK);
	  }
	
	/**
	 * GET rest service to get the chargingStationDTO containing the list of Chargingstation objects in a given perimeter
	 * @param GeolocationDTO
	 * @return chargingStationDTO
	 */
	@RequestMapping(value = "/perimeter", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	  public ResponseEntity<Object> getChargingStationInPerimeter(@Valid GeolocationDTO geolocationDTO) {
		ChargingStationDTO chargingStationDTO = chargingStationService.getChargingStationInPerimeter(geolocationDTO);
		if(chargingStationDTO.getChargingStationList().isEmpty())
			return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(chargingStationDTO, HttpStatus.OK);
	  }

}
