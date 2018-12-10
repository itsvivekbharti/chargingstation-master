package com.hubject.chargingstation.dto;

import javax.validation.constraints.NotNull;

import com.hubject.chargingstation.enumerator.ChargingStationQueryEnum;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Vivek
 * 
 * DTO entity class to get the search criteria
 *
 */
@Getter
@Builder
public class SearchDTO {
	
	@NotNull
	private ChargingStationQueryEnum queryField;
	@NotNull
	private String text;
}
