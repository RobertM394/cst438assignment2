package cst438assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CityController {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired 
	CityService cityService;

	@GetMapping("/cities/{city}")
	public String getCityInfo(@PathVariable("city") String cityName, 
			Model model) {
		
		//create new City Object
		CityInfo cityInfo = cityService.getCityInfo(cityName);
		
		//set correct time
		double tempFahrenheit = Math.round((cityInfo.timeAndTemp.temp - 273.15) * 9.0/5.0 + 32.0);
		cityInfo.timeAndTemp.temp = tempFahrenheit;

		//the HTML template receives data from the Model. Add city data to Model
		model.addAttribute("name", cityName);
		model.addAttribute("ID", cityInfo.city.getID());
		model.addAttribute("countryCode", cityInfo.country.getCode());
		model.addAttribute("countryName", cityInfo.country.getName());
		model.addAttribute("district", cityInfo.city.getDistrict());
		model.addAttribute("population", cityInfo.city.getPopulation());
		model.addAttribute("weather", cityInfo.timeAndTemp.temp);
		model.addAttribute("localTime", cityInfo.timeAndTemp.time);
		
		return "city_page";
	}
}
	