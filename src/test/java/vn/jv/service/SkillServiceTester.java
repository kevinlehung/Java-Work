package vn.jv.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import vn.jv.BaseTester;
import vn.jv.persist.domain.Skill;
import vn.jv.persist.repositories.UserRepo;

/**
 *
 * @author hunglevn@outlook.com
 *
 */

public class SkillServiceTester extends BaseTester {

	@Autowired@Qualifier("skillService")
	ISkillService skillService;
	
	@Test
	public void test() {
		try {
			for (int i = 0; i < 100; i++) {
				List<Skill> skills = skillService.findAll();	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}