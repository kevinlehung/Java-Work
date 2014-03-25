package vn.jv.service;

import java.util.List;

import vn.jv.persist.domain.WorkCategory;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public interface IWorkCategoryService extends IBaseService {
	public List<WorkCategory> findAll();
}