package vn.jv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.TOption;
import vn.jv.persist.repositories.TOptionRepo;

/**
 *
 * @author vodinh90@gmail.com
 *
 */
@Service("tOptionService")
public class TOptionService extends BaseService implements ITOptionService {
	@Autowired
	TOptionRepo tOptionRepo;
	
	//@Cacheable(value = {"TOptionService.findById"}, key = "#optionId")
	public TOption findById(Integer optionId) {
		return tOptionRepo.findOne(optionId);
	}
	
	public List<Integer> findKeyOptionOfQuestion(Integer questionId) {
		return tOptionRepo.findKeyOptionByQuestionId(questionId);
	}
}
