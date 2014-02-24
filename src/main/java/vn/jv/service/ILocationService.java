package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.City;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface ILocationService extends IBaseService {
	public List<City> findByCountryId(int countryId);
}
