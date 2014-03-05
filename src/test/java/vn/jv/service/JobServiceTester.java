package vn.jv.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import vn.jv.BaseTester;
import vn.jv.web.form.PostJobForm;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public class JobServiceTester extends BaseTester {
	@Autowired
	IJobService jobService;
	
	@Test
	public void testPostJob () {
		PostJobForm postJobForm = new PostJobForm();
		postJobForm.setCityId(1);
		postJobForm.setCountryId(1);
		postJobForm.setCustomRequiredSkill("1");
		postJobForm.setDescription("1");
		postJobForm.setOtherOption("1");
		
		List<Integer> requiredSkillIds = new ArrayList<Integer>();
		requiredSkillIds.add(1);
		requiredSkillIds.add(2);
		requiredSkillIds.add(3);
		postJobForm.setRequiredSkillIds(requiredSkillIds);
		
		postJobForm.setSalaryFromAmount(1);
		postJobForm.setSalaryToAmount(1);
		postJobForm.setSalaryType("FIXED_PRICE");
		postJobForm.setTitle("1");
		postJobForm.setWorkCategoryId(1);
		
		jobService.postJob(postJobForm , 1);
	}
}
