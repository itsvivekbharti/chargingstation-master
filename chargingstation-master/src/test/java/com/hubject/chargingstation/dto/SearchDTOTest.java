package com.hubject.chargingstation.dto;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.hubject.chargingstation.enumerator.ChargingStationQueryEnum;

@RunWith(SpringRunner.class)
public class SearchDTOTest {

	@Before
	  public void setUp() throws Exception {
	  }

	  @After
	  public void tearDown() throws Exception {
	  }

	  @Test
	  public void testChargingStation_HappyCase() {
		  SearchDTO searchDTO = SearchDTO.builder()
	      .queryField(ChargingStationQueryEnum.ZIPCODE)
	      .text("12345").build();
	    
	    assertEquals(ChargingStationQueryEnum.ZIPCODE,searchDTO.getQueryField());
	    assertEquals("12345",searchDTO.getText());
	    
	    searchDTO = SearchDTO.builder()
	  	      .queryField(ChargingStationQueryEnum.USER_DEFINED_ID)
	  	      .text("geo1").build();
	  	    
	  	assertEquals(ChargingStationQueryEnum.USER_DEFINED_ID,searchDTO.getQueryField());
	  	assertEquals("geo1",searchDTO.getText());
	  	    
	  	searchDTO = SearchDTO.builder()
	  		      .queryField(ChargingStationQueryEnum.GEOLOCATION)
	  		      .text("12345.12,23456.12").build();
	  		    
	  	assertEquals(ChargingStationQueryEnum.GEOLOCATION,searchDTO.getQueryField());
	  	assertEquals("12345.12,23456.12",searchDTO.getText());
	  }
}
