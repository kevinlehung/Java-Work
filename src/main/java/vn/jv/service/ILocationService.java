package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.City;
import vn.jv.persist.domain.Country;
import vn.jv.web.bean.CityBean;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface ILocationService extends IBaseService {
	public List<CityBean> findByCountryId(int countryId);

	public Country findCountryById(int countryId);

	public City findCityById(int cityId);
}
