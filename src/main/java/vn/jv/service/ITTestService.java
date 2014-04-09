package vn.jv.service;

import vn.jv.persist.domain.Skill;
import vn.jv.persist.domain.TTest;

/**
 *
 * @author vodinh90@gmail.com
 *
 */
public interface ITTestService extends IBaseService {
	public TTest saveTTest(int totalQuestion, int totalTime, Skill skill);
}
