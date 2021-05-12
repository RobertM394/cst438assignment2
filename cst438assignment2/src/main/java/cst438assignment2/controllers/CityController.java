package cst438assignment2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cst438assignment2.domain.CityInfo;
import cst438assignment2.services.CityService;


@Controller
public class CityController {
	
	@Autowired 
	CityService cityService;

	@GetMapping("/cities/{city}")
	public String getCityInfo(@PathVariable("city") String cityName, 
			Model model) {
		
		CityInfo cityInfo = cityService.getCityInfo(cityName);
		
		double tempFahrenheit = 
			Math.round((cityInfo.timeAndTemp.temp - 273.15) * 9.0/5.0 + 32.0);
		cityInfo.timeAndTemp.temp = tempFahrenheit;

		//ThymeLeaf allows you to access object attributes, including using get 
		//methods. This is a more DRY approach than adding each attribute to the
		//model individually.
		model.addAttribute("cityInfo", cityInfo);
		
		return "city_page";
	}
}
	