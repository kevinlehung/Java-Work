package vn.jv.persist.repositories;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.Country;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface CountryRepo extends BaseRepo<Country, Integer>, CountryCustomRepo<Country, Integer> {

}
