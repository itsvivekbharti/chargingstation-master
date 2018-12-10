package com.hubject.chargingstation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hubject.chargingstation.model.ChargingStation;

/**
 * @author Vivek
 * 
 * DAO class for all the DB interactions related to the ChargingStation entity
 * 
 *  Extends JPA CrudRepository
 *
 */
@Repository
public interface ChargingStationDAO extends JpaRepository<ChargingStation, Long>{

	/**
	 * Find ChargingStation by user defined id 
	 * @param text
	 * @return
	 */
	public List<ChargingStation> findByUserDefinedId(String text);

	/**
	 * Find all ChargingStations by zip code
	 * @param text
	 * @return
	 */
	public List<ChargingStation> findByZipCode(String text);
	
	/**
	 * 
	 * Find all ChargingStations in a given distance from latitude and longitude provided
	 * @param latitude
	 * @param longitude
	 * @param distance
	 * @return
	 */
	@Query("SELECT * FROM(" + 
			" SELECT *,(((acos(sin((:latitude*pi()/180)) * sin((latitude*pi()/180))+cos((:latitude*pi()/180)) * cos((latitude*pi()/180)) * cos(((:longitude - longitude)*pi()/180))))*180/pi())*60*1.1515*1.609344) as distance FROM ChargingStation) " + 
			"WHERE distance <= :distance")
	public Iterable<ChargingStation> fetchAllChargingStationsInPerimeter(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("distance") int distance);

}
