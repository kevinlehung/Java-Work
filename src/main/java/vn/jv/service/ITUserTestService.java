package vn.jv.service;

import vn.jv.persist.domain.TTest;
import vn.jv.persist.domain.TUserTest;
import vn.jv.persist.domain.User;
import vn.jv.web.bean.TestTrackingBean;

/**
 *
 * @author vodinh90@gmail.com
 *
 */
public interface ITUserTestService extends IBaseService {
	public TUserTest saveTUserTest(TTest tTest, User user);
	
	public TUserTest findByUserIdAndTestId(int userId, int testId);
	
	public TUserTest updateUserTest(TUserTest tUserTest);
	
	public TUserTest updateScoreAndCorrectCountTest(User currentUser, TestTrackingBean testBean);
}
