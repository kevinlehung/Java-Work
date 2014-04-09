package vn.jv.service;

import vn.jv.persist.domain.TQuestion;

/**
 *
 * @author vodinh90@gmail.com
 *
 */
public interface ITQuestionService extends IBaseService {
	public TQuestion findById(Integer questionId);
}
