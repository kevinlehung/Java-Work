package vn.jv.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import vn.jv.persist.domain.Skill;
import vn.jv.persist.repositories.RepoConfig;
import vn.jv.spring.context.CacheConfig;
import vn.jv.spring.context.SpringConfig;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(loader= AnnotationConfigContextLoader.class, classes = {/*WebConfig.class, */SpringConfig.class, CacheConfig.class, RepoConfig.class})
public class SkillServiceTester {

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