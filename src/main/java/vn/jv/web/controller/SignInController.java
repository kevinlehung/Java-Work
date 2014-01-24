package vn.jv.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.jv.constant.WebConstants;
import vn.jv.persist.repositories.IUserRepo;

@Controller
public class SignInController extends BaseController {
	/*@Autowired
	@Qualifier("userLoginDAO")
	private IUserLoginDAO userLoginDAO;*/
	
	@Autowired
	IUserRepo userRepo;
	
    @RequestMapping("/sec/sign_in")
    public ModelAndView showLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView(WebConstants.Views.SIGN_IN, "model", model);
    }

}
