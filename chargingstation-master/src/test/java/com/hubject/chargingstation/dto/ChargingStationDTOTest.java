package com.hubject.chargingstation.dto;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.hubject.chargingstation.dto.ChargingStationDTO;
import com.hubject.chargingstation.model.ChargingStation;

@RunWith(SpringRunner.class)
public class ChargingStationDTOTest {

	  @Before
	  public void setUp() throws Exception {
	  }

	  @After
	  public void tearDown() throws Exception {
	  }

	  @Test
	  public void testChargingStation_HappyCase() {
	    ChargingStation chargingStation = ChargingStation.builder()
	      .id(1l)
	      .UserDefinedId("geo1")
	      .zipCode("12344")
	      .latitude(1234.12)
	      .longitude(2345.56)
	      .build();
	    
	    List<ChargingStation> chargingStationList = new ArrayList<ChargingStation>();
	    chargingStationList.add(chargingStation);
	    ChargingStationDTO chargingStationDTO = ChargingStationDTO.builder()
	    		.chargingStationList(chargingStationList).build();

	    assertEquals(chargingStationDTO.getChargingStationList().size(),1);
	  }
}
