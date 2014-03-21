package vn.jv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.City;
import vn.jv.persist.domain.Country;
import vn.jv.persist.repositories.CityRepo;
import vn.jv.web.bean.CityBean;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Service
public class LocationService implements ILocationService {
	@Autowired
	private CityRepo cityRepo;
	
	@Cacheable(value = "LocationService.findByCountryId", key="#countryId")
	public List<CityBean> findByCountryId(int countryId) {
		List<City> cities = cityRepo.findByCountry(new Country(countryId));
		List<CityBean> cityBeans = new ArrayList<CityBean>();
		for (City city : cities) {
			cityBeans.add(new CityBean(city.getCityId(), city.getCityName(), city.getCountry().getCountryId()));
		}
		return cityBeans;
	}
	
	
	public Country findCountryById(int countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public City findCityById(int cityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
