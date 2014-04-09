package vn.jv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.TQuestion;
import vn.jv.persist.repositories.TQuestionRepo;

/**
 *
 * @author vodinh90@gmail.com
 *
 */
@Service("tQuestionService")
public class TQuestionService extends BaseService implements ITQuestionService {
	
	@Autowired
	TQuestionRepo tQuestionRepo;
	
	//@Cacheable(value = {"TQuestionService.findById"}, key = "#questionId")
	public TQuestion findById(Integer questionId) {
		return tQuestionRepo.findOne(questionId);
	}
}
