package com.hubject.chargingstation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubject.chargingstation.constant.ApplicationConstant;
import com.hubject.chargingstation.dao.ChargingStationDAO;
import com.hubject.chargingstation.dto.ChargingStationDTO;
import com.hubject.chargingstation.dto.GeolocationDTO;
import com.hubject.chargingstation.dto.SearchDTO;
import com.hubject.chargingstation.enumerator.ChargingStationQueryEnum;
import com.hubject.chargingstation.model.ChargingStation;
import com.hubject.chargingstation.service.ChargingStationService;

/**
 * @author Vivek
 * 
 * ChargingStationService implementation for all the service methods for manipulation 
 * and fetching data for ChargingStation Entity
 *
 */
@Service
public class ChargingStationServiceImpl implements ChargingStationService{

	@Autowired
	ChargingStationDAO chargingStationDAO;
	
	/* (non-Javadoc)
	 * @see com.hubject.chargingstation.service.ChargingStationService#save(com.hubject.chargingstation.model.ChargingStation)
	 */
	@Override
	public ChargingStation save(ChargingStation chargingStation) {
		return chargingStationDAO.save(chargingStation);
	}

	/* (non-Javadoc)
	 * @see com.hubject.chargingstation.service.ChargingStationService#get(com.hubject.chargingstation.dto.SearchDTO)
	 */
	@Override
	public ChargingStationDTO get(SearchDTO searchDTO) {
		String text = searchDTO.getText();
		ChargingStationQueryEnum queryField = searchDTO.getQueryField();
		if(queryField.equals(ChargingStationQueryEnum.USER_DEFINED_ID)) {
			return ChargingStationDTO.builder().chargingStationList(chargingStationDAO.findByUserDefinedId(text)).build();
		}else if(queryField.equals(ChargingStationQueryEnum.ZIPCODE)) {
			return ChargingStationDTO.builder().chargingStationList(chargingStationDAO.findByZipCode(text)).build();
		}else
			throw new IllegalArgumentException("Wrong search query type");
	}

	@Override
	public ChargingStationDTO getChargingStationInPerimeter(GeolocationDTO geolocationDTO) {
		Iterable<ChargingStation> chargingStationIterable = chargingStationDAO.fetchAllChargingStationsInPerimeter
				(geolocationDTO.getLatitude(), geolocationDTO.getLongitude()
						, ApplicationConstant.DEFAULT_DISTANCE);
		List<ChargingStation> chargingStationList = new ArrayList<ChargingStation>();
		chargingStationIterable.forEach(chargingStationList::add);
		return ChargingStationDTO.builder()
				.chargingStationList(chargingStationList).build();
	}
}
