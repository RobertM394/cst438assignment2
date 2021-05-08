package cst438assignment2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="city")
public class City {
	
	@Id
	private int ID;
	private String name;
	private String district;
	private int population;
	
	//transient marks extra field in an entity class 
	//that is not written to or read from the database
	@Transient
	TimeAndTemp timeAndTemp;
	
	@ManyToOne
	@JoinColumn(name = "countrycode", referencedColumnName="code")
	private Country country;
	
	public City() { }

	public City(int iD, String name, String district, int population, Country country)
	{
		super();
		ID = iD;
		this.name = name;
		this.district = district;
		this.population = population;
		this.country = country;
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDistrict()
	{
		return district;
	}

	public void setDistrict(String district)
	{
		this.district = district;
	}

	public int getPopulation()
	{
		return population;
	}

	public void setPopulation(int population)
	{
		this.population = population;
	}

	public TimeAndTemp getTimeAndTemp()
	{
		return timeAndTemp;
	}

	public void setTimeAndTemp(TimeAndTemp timeAndTemp)
	{
		this.timeAndTemp = timeAndTemp;
	}

	public Country getCountry()
	{
		return country;
	}

	public void setCountry(Country country)
	{
		this.country = country;
	}
	
}

