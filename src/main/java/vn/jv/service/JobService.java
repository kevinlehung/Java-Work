package vn.jv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.jv.persist.repositories.IWorkCategoryRepo;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
@Service
public class JobService implements IJobService {
	@Autowired
	private IWorkCategoryRepo workCategoryRepo;
}
