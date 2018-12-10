package com.hubject.chargingstation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Vivek
 * 
 * ChargingStation entity for serialization and fetch of charging station data
 *
 */
@Getter
@Builder
@Entity
public class ChargingStation {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String userDefinedId;
	@NotNull
	private double latitude;
	@NotNull
	private double longitude;
	@NotNull
	private String zipCode;
}
