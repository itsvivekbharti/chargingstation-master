package com.hubject.chargingstation.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.hubject.chargingstation.dao.ChargingStationDAO;
import com.hubject.chargingstation.model.ChargingStation;
import com.hubject.chargingstation.service.ChargingStationService;

@RunWith(SpringRunner.class)
public class ChargingStationServiceImplTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	private ChargingStation getDummyChargingStation() {
		return ChargingStation.builder().userDefinedId("geo1").zipCode("12344").latitude(1234.12).longitude(2345.56)
				.build();
	}

	private ChargingStation getDummySerializedChargingStation() {
		return ChargingStation.builder().id(1l).userDefinedId("geo1").zipCode("12344").latitude(1234.12)
				.longitude(2345.56).build();
	}

	@Test
	public void testSave_HappyCase() throws IOException {
		ChargingStationDAO mockChargingStationDAO = PowerMockito.mock(ChargingStationDAO.class);
		doReturn(getDummySerializedChargingStation()).when(mockChargingStationDAO).save(getDummyChargingStation());
		ChargingStationServiceImpl chargingStationServiceImpl = new ChargingStationServiceImpl();
		ChargingStation chargingStation = chargingStationServiceImpl.save(getDummyChargingStation());
		assertNotNull(chargingStation);
	}
	
	@Test
	public void testSave_NullCase() throws IOException {
		ChargingStationDAO mockChargingStationDAO = PowerMockito.mock(ChargingStationDAO.class);
		doReturn(null).when(mockChargingStationDAO).save(getDummyChargingStation());
		ChargingStationServiceImpl chargingStationServiceImpl = new ChargingStationServiceImpl();
		ChargingStation chargingStation = chargingStationServiceImpl.save(getDummyChargingStation());
		assertNull(chargingStation);
	}

}
