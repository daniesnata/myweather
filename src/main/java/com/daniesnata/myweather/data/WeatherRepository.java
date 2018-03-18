package com.daniesnata.myweather.data;

import com.daniesnata.myweather.domain.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;

/**
 * Repository interface for Weather domain class
 * extends the spring data MongoRepository
 * @author danielsaldinata
 * @version 1.0
 */
@Repository
public interface WeatherRepository extends MongoRepository<Weather, String> {

	/**
	 * Finds a weather document from DB that the creation date greater than specified time
	 * @param countryLocation the country/location pair code
	 * @param time the time specified
	 * @return Weather document
	 */
    @Query("{ countryLocation : ?0 , createdAt : { $gte : ?1 } }")
    Weather findByCreatedAtGreaterThan(String countryLocation, ZonedDateTime time);

}
