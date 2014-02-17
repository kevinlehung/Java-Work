package vn.jv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.WorkCategory;
import vn.jv.persist.repositories.IWorkCategoryRepo;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Service("workCategoryService")
public class WorkCategoryService extends BaseService implements IWorkCategoryService {
	@Autowired
	IWorkCategoryRepo workCategoryRepo;
	
	@Cacheable("WorkCategoryService.findAll")
	public List<WorkCategory> findAll() {
		return workCategoryRepo.findAll();
	}

}
