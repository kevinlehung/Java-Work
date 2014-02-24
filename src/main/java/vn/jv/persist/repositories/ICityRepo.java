package vn.jv.persist.repositories;

import java.util.List;

import vn.jv.persist.domain.City;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface ICityRepo extends ICityCustomRepo<City, Integer>, IBaseRepo<City, Integer> {

	List<City> findByCountryId(int countryId);

}
