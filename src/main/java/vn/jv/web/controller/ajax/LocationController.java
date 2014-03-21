package vn.jv.web.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.jv.persist.domain.City;
import vn.jv.service.ILocationService;
import vn.jv.web.bean.CityBean;
import vn.jv.web.controller.BaseController;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Controller
@RequestMapping("/loc")
public class LocationController extends BaseController {
	@Autowired
	private ILocationService locationService;
	
	@RequestMapping(value="/country/{countryId}/cities", method=RequestMethod.GET)
	public @ResponseBody List<CityBean> loadCities(@PathVariable(value="countryId") int countryId, HttpServletResponse response) {
		List<CityBean> cities = locationService.findByCountryId(countryId);
		return cities;
	}
}
