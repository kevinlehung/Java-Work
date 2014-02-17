package vn.jv.persist.repositories;

import vn.jv.persist.domain.Country;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface ICountryRepo extends IBaseRepo<Country, Integer>, ICountryCustomRepo<Country, Integer> {

}
