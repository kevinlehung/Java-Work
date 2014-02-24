package vn.jv.persist.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.AccessType;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CITY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AccessType("property")
	private int cityId;

	@Column(name="CITY_NAME")
	private String cityName;

	@Column(name="COUNTRY_ID")
	private int countryId;
	
	public City(int cityId, String cityName) {
		this.cityId = cityId;
		this.cityName = cityName;
	}
	
	public City() {
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	
}