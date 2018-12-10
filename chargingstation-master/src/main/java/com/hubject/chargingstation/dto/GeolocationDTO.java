package com.hubject.chargingstation.dto;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GeolocationDTO {
@NotNull	
double latitude;
@NotNull
double longitude;
}
