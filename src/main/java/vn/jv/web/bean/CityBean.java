package vn.jv.web.bean;

import java.io.Serializable;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public class CityBean implements Serializable {
	private int cityId;
	private String cityName;
	private int countryId;

	public CityBean() {
		
	}
	
	public CityBean(int cityId, String cityName, int countryId) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.countryId = countryId;
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
