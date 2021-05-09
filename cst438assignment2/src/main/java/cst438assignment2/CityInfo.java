package cst438assignment2;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

public class CityInfo {

	public City city;
	public Country country;
	public TimeAndTemp timeAndTemp;
	
	public CityInfo(City city, Country country, TimeAndTemp timeAndTemp)
	{
		this.city = city;
		this.country = country;
		this.timeAndTemp = timeAndTemp;
	}

}
