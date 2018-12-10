package com.hubject.chargingstation.dto;

import java.util.List;

import com.hubject.chargingstation.model.ChargingStation;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Vivek
 * 
 * DTO class to return the chargingStation objects list for the search criteria
 *
 */
@Getter
@Builder
public class ChargingStationDTO {

	private List<ChargingStation> chargingStationList;
}
