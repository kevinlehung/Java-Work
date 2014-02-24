package vn.jv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.City;
import vn.jv.persist.repositories.ICityRepo;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Service
public class LocationService implements ILocationService {
	@Autowired
	private ICityRepo cityRepo;
	
	@Cacheable(value = "LocationService.findByCountryId", key="#countryId")
	public List<City> findByCountryId(int countryId) {
		List<City> cities = cityRepo.findByCountryId(countryId);
		return cities;
	}

}
