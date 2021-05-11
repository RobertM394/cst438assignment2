package cst438assignment2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cst438assignment2.CityRepository;
import cst438assignment2.CountryRepository;
import cst438assignment2.domain.City;
import cst438assignment2.domain.CityInfo;
import cst438assignment2.domain.Country;
import cst438assignment2.domain.TimeAndTemp;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private WeatherService weatherService;
	
	public CityInfo getCityInfo(String cityName) {
		//create City, Country, and TimeAndTemp objects. Then create CityInfo object
		//and add attributes from City, Country, and TimeAndTemp. Return the CityInfo object with 
		//all attributes added.
		
		//get cities list from database and assign first element to city object
		List<City> cities = cityRepository.findByName(cityName);
		City city = cities.get(0);
		
		//use country name in cities object to retrieve country info from database
		Country country = countryRepository.findByCode("USA"); //need to fix
		
		//get time and temp for city
		TimeAndTemp timeAndTemp = weatherService.getTimeAndTemp(cityName);
		
		//add all attributes to new CityInfo object and return CityInfo
		CityInfo cityInfo = new CityInfo(city, country, timeAndTemp);
		return cityInfo;
		
	}
}
