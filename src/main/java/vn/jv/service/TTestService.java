package vn.jv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.TTest;
import vn.jv.persist.repositories.TTestRepo;

/**
 *
 * @author vodinh90@gmail.com
 *
 */

@Service("tTestService")
public class TTestService extends BaseService implements ITTestService {
	
	@Autowired
	private TTestRepo tTestRepo;
	
	public TTest saveTTest(int totalQuestion, int totalTime, Skill skill) {
		TTest tTest = new TTest(totalQuestion, totalTime, skill);
		return tTestRepo.save(tTest);
	}
	
}
