package vn.jv.service;

import vn.jv.persist.domain.TQuestion;
import vn.jv.persist.domain.TTest;
import vn.jv.persist.domain.TTestQuestion;

/**
 *
 * @author vodinh90@gmail.com
 *
 */
public interface ITTestQuestionService extends IBaseService {
	public TTestQuestion saveTTestQuestion(TQuestion tQuestion, TTest tTest, int sequence);
}
