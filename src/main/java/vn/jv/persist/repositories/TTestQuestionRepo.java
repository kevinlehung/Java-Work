package vn.jv.persist.repositories;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.TTestQuestion;

/**
 *
 * @author vodinh90@gmail.com
 *
 */
public interface TTestQuestionRepo extends BaseRepo<TTestQuestion, Integer>, TTestQuestionCustomRepo<TTestQuestion, Integer> {

}
