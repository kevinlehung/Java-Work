package vn.jv.persist.repositories;

import java.util.List;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.City;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface CityRepo extends BaseRepo<City, Integer>, CityCustomRepo<City, Integer> {

	List<City> findByCountryId(int countryId);

}
