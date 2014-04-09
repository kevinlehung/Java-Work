package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.TOption;

/**
 *
 * @author vodinh90@gmail.com
 *
 */
public interface ITOptionService {
	public TOption findById(Integer optionId);
	
	public List<Integer> findKeyOptionOfQuestion(Integer questionId);
}
