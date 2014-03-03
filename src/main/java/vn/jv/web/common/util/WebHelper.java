package vn.jv.web.common.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.City;
import vn.jv.persist.domain.Country;
import vn.jv.persist.domain.Job;
import vn.jv.persist.repositories.ICityRepo;
import vn.jv.persist.repositories.ICountryRepo;
import vn.jv.persist.repositories.ISkillRepo;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Service
public class WebHelper {
	@Autowired
	private static ICountryRepo countryRepo;
	
	@Autowired
	private static ICityRepo cityRepo;
	
	@Autowired
	private static ISkillRepo skillRepo;
	
	public String buildocationText(int countryId, int cityId) {
		String location = "";
		
		if (countryId != 0) {
			Country country = countryRepo.findOne(countryId);
			location = country.getCountryName();
		}
		
		if (cityId != 0) {
			City city = cityRepo.findOne(cityId);
			location = location + "/" + city.getCityName();
		}
		
		if (StringUtils.isEmpty(location)) {
			location = "Anywhere";
		}
		return location;
	}
	
	public String buildSalaryTypeText(String salaryType) {
		return Job.SALARY_TYPE_TEXT_MAPPING.get(salaryType);
	}
	
	public String buildSalaryText(long salaryFromAmount, long salaryToAmount) {
		if (salaryFromAmount == 0 && salaryToAmount == 0) {
			return "Not sure";
		}
		
		if (salaryFromAmount == salaryToAmount) {
			return salaryFromAmount + "$";
		}
		
		if (salaryFromAmount == 0) {
			return "Less than " + salaryFromAmount + "$";
		}
		
		return salaryFromAmount + "$ - " + salaryToAmount + "$";
	}
	
}
