package com.hubject.chargingstation.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ChargingStationTest {

	  @Before
	  public void setUp() throws Exception {
	  }

	  @After
	  public void tearDown() throws Exception {
	  }

	  @Test
	  public void testChargingStation_HappyCase() {
	    ChargingStation chargingStatiom = ChargingStation.builder()
	      .id(1l)
	      .UserDefinedId("geo1")
	      .zipCode("12344")
	      .latitude(1234.12)
	      .longitude(2345.56)
	      .build();

	    assertEquals((Object)1l,(Object)chargingStatiom.getId());
	    assertEquals("geo1",chargingStatiom.getUserDefinedId());
	    assertEquals("12344",chargingStatiom.getZipCode());
	    assertEquals((Object)1234.12,chargingStatiom.getLatitude());
	    assertEquals((Object)2345.56,chargingStatiom.getLongitude());
	  }
}
