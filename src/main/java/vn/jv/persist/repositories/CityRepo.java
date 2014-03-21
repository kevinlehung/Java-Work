package vn.jv.persist.repositories;

import java.util.List;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.City;
import vn.jv.persist.domain.Country;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface CityRepo extends BaseRepo<City, Integer>, CityCustomRepo<City, Integer> {

	List<City> findByCountry(Country country);

}
