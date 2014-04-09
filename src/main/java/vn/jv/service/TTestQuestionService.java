package vn.jv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.TQuestion;
import vn.jv.persist.domain.TTest;
import vn.jv.persist.domain.TTestQuestion;
import vn.jv.persist.repositories.TTestQuestionRepo;

/**
 *
 * @author vodinh90@gmail.com
 *
 */

@Service("tTestQuestionService")
public class TTestQuestionService extends BaseService implements ITTestQuestionService {

	@Autowired
	private TTestQuestionRepo tTestQuestionRepo;
	
	public TTestQuestion saveTTestQuestion(TQuestion tQuestion, TTest tTest, int sequence) {
		TTestQuestion tTestQuestion = new TTestQuestion(tQuestion, tTest, sequence);
		return tTestQuestionRepo.save(tTestQuestion); 
	}
	
}
