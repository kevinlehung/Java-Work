package vn.jv.web.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.jv.service.ISkillService;
import vn.jv.web.bean.SkillBean;
import vn.jv.web.controller.BaseController;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
@Controller
@RequestMapping("/skill")
public class SkillController extends BaseController {
	@Autowired
	private ISkillService skillService;

	
	@RequestMapping(value="/workCategory/{workCategoryId}/skills", method=RequestMethod.GET)
	public @ResponseBody List<SkillBean> loadSkills(@PathVariable(value="workCategoryId") int workCategoryId, HttpServletResponse response) {
		List<SkillBean> skillsBean = skillService.findByWorkCategoryId(workCategoryId);
		return skillsBean;
	}
}
