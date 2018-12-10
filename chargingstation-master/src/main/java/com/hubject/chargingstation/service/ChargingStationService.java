package com.hubject.chargingstation.service;

import org.springframework.stereotype.Service;
import com.hubject.chargingstation.dto.ChargingStationDTO;
import com.hubject.chargingstation.dto.GeolocationDTO;
import com.hubject.chargingstation.dto.SearchDTO;
import com.hubject.chargingstation.model.ChargingStation;

/**
 * @author Vivek
 * 
 * ChargingStation service class for buisness logic of chargingstation entity
 *
 */
@Service
public interface ChargingStationService {

	/**
	 * Save the chargingStation object into the database
	 * 
	 * @param chargingStation
	 * @return
	 */
	public ChargingStation save(ChargingStation chargingStation);
	
	/**
	 * Get ChargingStationDTO(List of Chargingstation objects) for a given criteria
	 * 
	 * @param searchDTO
	 * @return
	 */
	public ChargingStationDTO get(SearchDTO searchDTO);
	
	/**
	 * Get ChargingStationDTO(List of Chargingstation objects) for a given perimeter of a geo location
	 * 
	 * @param searchDTO
	 * @return
	 */
	public ChargingStationDTO getChargingStationInPerimeter(GeolocationDTO geolocationDTO);
}
